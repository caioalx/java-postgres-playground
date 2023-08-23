package com.example.empresaFinanceira.dao;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.empresaFinanceira.model.Transacao;

public class TransacaoDAO {
    private final List<Transacao> lista = new LinkedList<>();

    public List<Transacao> getLista() {
        return Collections.unmodifiableList(lista);
    }    

    public List<Transacao> filtrar(String cliente) {
        return filtrar(transacao -> transacao.getCliente().equals(cliente));
    }  

    public List<Transacao> filtrar(char tipo) {
        return filtrar(transacao -> transacao.getTipo() == tipo);
    }    
    
    public List<Transacao> filtrar(String cliente, char tipo) {
        return filtrar(transacao -> transacao.getCliente().equals(cliente) && transacao.getTipo() == tipo);
    }     

    private List<Transacao> filtrar(Predicate<Transacao> predicado) {
        return lista.stream().filter(predicado).collect(Collectors.toCollection(LinkedList::new));
    }  

    public Transacao adicionar(Transacao nova) {
        if(nova.getTipo() != 'R') {
            lista.add(nova);
            return nova;
        }
        
        int totalRetiradas = 0;
        for (var transacao : lista) {
            var ontem = nova.getDataHora().minusDays(1);
            if(transacao.getCliente().equals(nova.getCliente()) 
                && transacao.getTipo() == 'R' 
                && transacao.getDataHora().isAfter(ontem)) {
                    totalRetiradas++;
            }
        }

        if(totalRetiradas >= 2) {
            var copia = Transacao.newSuspeita(nova);
            lista.add(copia);
            return copia;
        } 

        lista.add(nova);
        return nova;
    }

    public double getSaldo(final String cliente) {
        final var transacoes = filtrar(cliente);

        double saldo = 0.0;
        for(final var transacao : transacoes) {
            final double sinal = transacao.getTipo() == 'D' ? 1 : -1;
            final double valor = transacao.getValorMoedaLocal();
            saldo += sinal * valor;
        }

        return saldo;
    }

}
