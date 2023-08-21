package com.example;

import java.util.Scanner;

import com.example.model.Cliente;

public class AppScanner {
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Criando classes");
        System.out.println();

        Cliente cliente = new Cliente();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        cliente.setNome(scanner.nextLine());

        System.out.println("Digite o cpf: ");
        cliente.setCpf(scanner.nextLine());

        System.out.println("Digite a renda: ");
        cliente.setRenda(scanner.nextDouble());

        System.out.println("Digite o ano nascimento: ");
        cliente.setAnoNascimento(scanner.nextInt());

        scanner.nextLine();
        System.out.println("Digite o sexo: ");
        String sexo = scanner.nextLine();
        cliente.setSexo(sexo.charAt(0));        

        System.out.println();

        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Renda: " + cliente.getRenda());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("Ano de nascimento: " + cliente.getAnoNascimento());
        System.out.println("Especial: " + cliente.isEspecial());  


    }

}
