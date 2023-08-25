package com.example.escola.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AlunoTest {
    
    @Test
    public void calculaMediaComSucesso() {
        double nota1 = 8;
        double nota2 = 5;
        double nota3 = 7;

        Aluno aluno = new Aluno();
        aluno.setNome("Caio");
        aluno.setMatricula(1);
        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
        aluno.setNota3(nota3);
        
        double esperado = 6.66;
        double obtido = aluno.calculaMedia();
        assertEquals(esperado, obtido, 0.01);
    }

    @Test
    public void insereNota1Invalida() {
        double nota1 = 12;
        Aluno aluno = new Aluno();
        aluno.setNome("Caio");
        aluno.setMatricula(1);
        assertThrows(IllegalArgumentException.class, () -> aluno.setNota1(nota1));
    }

    @Test
    public void insereNota2Invalida() {
        double nota2 = -1;
        Aluno aluno = new Aluno();
        aluno.setNome("Caio");
        aluno.setMatricula(1);
        assertThrows(IllegalArgumentException.class, () -> aluno.setNota2(nota2));
    } 
    
    @Test
    public void insereNota3Invalida() {
        double nota3 = 15;
        Aluno aluno = new Aluno();
        aluno.setNome("Caio");
        aluno.setMatricula(1);
        assertThrows(IllegalArgumentException.class, () -> aluno.setNota3(nota3));
    }     


}
