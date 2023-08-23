package com.example.empresaFinanceira.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.example.empresaFinanceira.dao.TransacaoDAO;

public class TransacaoTest {
    private TransacaoDAO dao = new TransacaoDAO();

    @Test
    void testAdicionarTransacoesNaoSupeitas() {
        dao.adicionar(new Transacao("Caio", 100, "BRL", 'R'));
        var utlima = dao.adicionar(new Transacao("Caio", 50, "BRL", 'R'));
        assertFalse(utlima.isSuspeita());
    }     

    @Test
    void testAdicionarUmaTransacaoRetiradaNaoSuspeita() {
        var transacao = dao.adicionar(new Transacao("Caio", 10, "BRL", 'R'));
        assertFalse(transacao.isSuspeita());
    } 

    @Test
    void testAdicionarTransacoesTransferenciasNaoSuspeitas() {
        dao.adicionar(new Transacao("Caio", 100, "BRL", 'T'));
        dao.adicionar(new Transacao("Caio", 100, "BRL", 'T'));
        var transacao = dao.adicionar(new Transacao("Caio", 10, "BRL", 'T'));
        assertFalse(transacao.isSuspeita());
    }
   
    @Test
    void testAdicionarTransacoesRetiradasSuspeitas() {
        dao.adicionar(new Transacao("Caio", 100, "BRL", 'R'));
        dao.adicionar(new Transacao("Caio", 100, "BRL", 'R'));
        var ultima = dao.adicionar(new Transacao("Caio", 10, "BRL", 'R'));
        assertTrue(ultima.isSuspeita());
    }

    @Test
    void testAdicionarTransacoesRetiradasDiasDiferentes() {
        var primeira = dao.adicionar(new Transacao("Caio", 100, "BRL", 'R'));
        var anteontem = LocalDateTime.now().minusDays(2);
        primeira.setDataHora(anteontem);
        
        dao.adicionar(new Transacao("Caio", 100, "BRL", 'R'));
        var ultima = dao.adicionar(new Transacao("Caio", 10, "BRL", 'R'));
        assertFalse(ultima.isSuspeita());
    }    
   
}
