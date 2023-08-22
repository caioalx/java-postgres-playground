package com.example.empresaFinanceira.model;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Transacao {
    private Integer id;
    private String cliente;
    private double valor;
    private String moeda;
    private char tipo;
    private List<Transacao> lista = new LinkedList<>();

    public Transacao(String cliente, double valor, String moeda, char tipo) {
        this.cliente = cliente;
        this.valor = valor;
        this.moeda = moeda;
        this.tipo = tipo;
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

    public void adicionar(Transacao transacao) {
        lista.add(transacao);
    }

    public double getSaldo(String cliente) {
        double saldo = 0.0;

        for(Transacao transacao : lista) {
            if(transacao.cliente.equals(cliente)) {
                saldo += transacao.valor;
            }
        }

        return saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public List<Transacao> getLista() {
        return lista;
    }

    public void setLista(List<Transacao> todasTransacoes) {
        this.lista = todasTransacoes;
    }

}
