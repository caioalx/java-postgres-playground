package com.example.model;

import java.math.BigDecimal;

public class Produto {
    private Long id;
    private String nome;
    private Marca marca;
    private BigDecimal valor;

    public Produto(){}

    public Produto(String nome, Marca marca, BigDecimal valor) {
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }   
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
