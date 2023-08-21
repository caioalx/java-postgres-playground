package com.example.educacao.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    @Test
    void calcularMediaComErroDePrecisao() {
        var aluno = new Aluno();
        aluno.setNota1(10.0);
        aluno.setNota2(8.0);
        aluno.setNota3(8.0);
        var esperado = 8.66;
        var obtido = aluno.calculaMedia();
        assertEquals(esperado, obtido, 0.01);
    }

    @Test
    void calcularMediaComValoresIguais() {
        var aluno = new Aluno();
        aluno.setNota1(10);
        aluno.setNota2(10);
        aluno.setNota3(10);
        var esperado = 10;
        var obtido = aluno.calculaMedia();
        assertEquals(esperado, obtido, 0.01);
    }    

    
}
