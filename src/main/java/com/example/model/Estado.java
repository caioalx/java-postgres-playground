package com.example.model;

public class Estado {
    private Long id;
    private String nome;
    private String uf;
    private RegiaoGeografica regiao;
    private Integer areaKm2;
    private Integer populacao;

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
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public RegiaoGeografica getRegiao() {
        return regiao;
    }
    public void setRegiao(RegiaoGeografica regiao) {
        this.regiao = regiao;
    }
    public Integer getAreaKm2() {
        return areaKm2;
    }
    public void setAreaKm2(Integer areaKm2) {
        this.areaKm2 = areaKm2;
    }
    public Integer getPopulacao() {
        return populacao;
    }
    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    @Override
    public String toString() {
        return "Estado: id=" + id + ", nome=" + nome + ", uf=" + uf;
    }
    
}
