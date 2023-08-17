package com.example;

public class Cliente {
    private String nome;
    private double renda;
    private char sexo;
    private int anoNascimento;
    private boolean especial;
    private String cpf;

    public Cliente() {
     System.out.println("Criando um  cliente");  
     double aleatorio = Math.random(); 
     if(aleatorio > 0.5) {
        especial = true;
     }
    }

    public Cliente(double renda, char sexo) {
        this();
        System.out.println("Criando um  cliente com parâmetros"); 
        setRenda(renda);
        setSexo(sexo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.isBlank()) {
            System.out.println("O nome é obrigatório");
        } else {
            this.nome = nome.toUpperCase().trim();
        }
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        if(renda >= 0) {
            this.renda = renda;
        } else {
            System.out.println("A renda deve ser maior que zero");
        }
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if(sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            System.out.println("O sexo deve ser M ou F");
        }
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }    
}