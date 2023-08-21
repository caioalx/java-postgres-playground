package com.example;

import java.util.Arrays;

import com.example.model.Cliente;

public class AppClasses {
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Criando classes");
        System.out.println();

        Cliente cliente = new Cliente();
        cliente.setNome("Caio Silva");
        cliente.setCpf("999");
        cliente.setRenda(1000);
        cliente.setSexo('M');
        cliente.setAnoNascimento(1980);
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Renda: " + cliente.getRenda());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("Ano de nascimento: " + cliente.getAnoNascimento());
        System.out.println("Especial: " + cliente.isEspecial());  

        System.out.println(Arrays.toString(cliente.getNome().split(" ")));

        System.out.println(cliente.getNome().charAt(0));

        Cliente cliente2 = new Cliente(-2000, 'F');
        cliente2.setNome("CAIO SILVA");
        cliente2.setCpf("999");
        System.out.println();

        cliente2.setAnoNascimento(1990);
        System.out.println("Nome: " + cliente2.getNome());
        System.out.println("Renda: " + cliente2.getRenda());
        System.out.println("Sexo: " + cliente2.getSexo());
        System.out.println("Ano de nascimento: " + cliente2.getAnoNascimento());       
        System.out.println("Especial: " + cliente2.isEspecial()); 
        
        System.out.println();

        if(cliente.getCpf().equals(cliente2.getCpf())) {
            System.out.println("Cliente 1 e cliente 2 tem o mesmo cpf");
        }

        if(cliente.getNome().equalsIgnoreCase(cliente2.getNome())) {
            System.out.println("Cliente 1 e cliente 2 tem o mesmo nome");
        }        

        System.out.println();

    }

}
