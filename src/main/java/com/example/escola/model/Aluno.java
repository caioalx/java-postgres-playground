package com.example.escola.model;

public class Aluno {
    private String nome;
    private int matricula;
    private double nota1;
    private double nota2;
    private double nota3;

    public Aluno() {}

    public double calculaMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    private void validaNota(double nota) {
        if(nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        validaNota(nota1);
        this.nota1 = nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        validaNota(nota2);
        this.nota2 = nota2;
    }
    public double getNota3() {
        return nota3;
    }
    public void setNota3(double nota3) {
        validaNota(nota3);
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", matricula=" + matricula + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3="
                + nota3 + "]";
    }
        
}
