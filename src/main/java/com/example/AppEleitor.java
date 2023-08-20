package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppEleitor {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite a data de nascimento do eleitor: ");
        String dataNascimento = scanner.nextLine();

        Cidadao cidadao = new Cidadao();
        cidadao.setDataNascimento(LocalDate.parse(dataNascimento, dateTimeFormatter));

        System.out.println(cidadao.eleitor());
    }

}
