package com.example.empresaFinanceira.model;

import java.time.LocalDateTime;

import com.example.empresaFinanceira.currency.CurrencyAPI;

public class Transacao {
    private static final String MOEDA_LOCAL = "BRL";

    private Integer id;
    private String cliente;
    private double valor;
    private String moeda;
    private char tipo;
    private LocalDateTime dataHora;
    private boolean suspeita;

    public Transacao(String cliente, double valor, String moeda, char tipo) {
        this.cliente = cliente;
        this.valor = valor;
        this.moeda = moeda;
        this.tipo = tipo;
        this.dataHora = LocalDateTime.now(); 
    }

    public static Transacao newSuspeita(Transacao transacao) {
        var copia = new Transacao(transacao.cliente, transacao.valor, transacao.moeda, transacao.tipo);
        copia.suspeita = true;
        return copia;
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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean isSuspeita() {
        return suspeita;
    }

    public double getValorMoedaLocal() {
        final double multiplo = moeda.equals(MOEDA_LOCAL) ? 1 : CurrencyAPI.getQuote(moeda, MOEDA_LOCAL);
        return multiplo * valor;
    }     

    void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Transacao [id=" + id + ", cliente=" + cliente + ", valor=" + valor + ", moeda=" + moeda + ", tipo="
                + tipo + "]";
    }
    

}
