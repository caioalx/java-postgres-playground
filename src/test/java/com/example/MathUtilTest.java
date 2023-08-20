package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static com.example.MathUtil.mdc;

public class MathUtilTest {
    
    @Test
    void testMdcP1BImpar() {
        int a = 6;
        int b = 3;
        int esperado = 3;
        int obtido = mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP1BPar() {
        int a = 6;
        int b = 2;
        int esperado = 2;
        int obtido = mdc(a, b);

        assertEquals(esperado, obtido);
    }  
    
    @Test
    void testMdcP3Negativo() {
        int a = -6;
        int b = 0;
        int esperado = 6;
        int obtido = mdc(a, b);

        assertEquals(esperado, obtido);
    }
    
    @Test
    void testMdcP3Positivo() {
        int a = 6;
        int b = 0;
        int esperado = 6;
        int obtido = mdc(a, b);

        assertEquals(esperado, obtido);
    }  
    
    @Test
    void testMdcP5Crescente() {
        int a = 2;
        int b = 6;
        int esperado = mdc(a, b);
        int obtido = mdc(b, a);

        assertEquals(esperado, obtido);
    }  
    
    @Test
    void testMdcP5Decrescente() {
        int a = 6;
        int b = 2;
        int esperado = mdc(a, b);
        int obtido = mdc(b, a);

        assertEquals(esperado, obtido);
    }  
    
    @Test
    void testMdcP7() {
        int a = 6;
        int b = 2;
        int esperado = mdc(-a, b);
        int obtido = mdc(-b, -a);

        assertEquals(esperado, obtido);
    }     

    @Test
    void testMdcP8() {
        int a = 6;
        int esperado = 6;
        int obtido = mdc(a, a);

        assertEquals(esperado, obtido);
    } 
    
    @Test
    void testMdcP8Negativo() {
        int a = -6;
        int esperado = 6;
        int obtido = mdc(a, a);

        assertEquals(esperado, obtido);
    }     

    @Test
    void testMdcP12Primos() {
        int p = 7;
        int a = 2;
        int esperado = 1;
        int obtido = mdc(p, a);

        assertEquals(esperado, obtido);
    }  

    @Test
    void testMdcP12PrimoEUm() {
        int p = 7;
        int a = 1;
        int esperado = 1;
        int obtido = mdc(p, a);

        assertEquals(esperado, obtido);
    }    

    @Test
    void testMdcCasoGeral30e12() {
        int a = 30;
        int b = 12;
        int esperado = 6;
        int obtido = mdc(a, b);

        assertEquals(esperado, obtido);
    }  
    
    @Test
    void testMdcCasoGeral12e9() {
        int a = 12;
        int b = 9;
        int esperado = 3;
        int obtido = mdc(a, b);

        assertEquals(esperado, obtido);
    }  
    
    @Test
    void testMdcP4() {
        int m = 2;
        int a = 4;
        int b = 3;
        int esperado = mdc(m*a, m*b);
        int obtido = m * mdc(a, b);

        assertEquals(esperado, obtido);
    } 
    
    @Test
    void testMdcP9() {
        int a = 6;
        int b = 3;
        int c = 2;

        assertTrue(mdc(a, mdc(b, c)) == mdc(mdc(a,b),c) && mdc(mdc(a,b), c) == mdc(a, b, c));
    } 
    
    @Test
    void testMdc3Valores() {
        int a = 12;
        int b = 6;
        int c = 4;

        assertTrue(mdc(a, mdc(b, c)) == mdc(mdc(a,b),c));
    } 
    
    @Test
    void testMdcNenhumValor() {
       var exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> mdc());
       System.out.println(exception);
    }  

    @Test
    void testMdcNull() {
       var exception = assertThrows(NullPointerException.class, () -> mdc(null));
       var msgEsperado = "É necessário passar um valor diferente de nulo.";
       assertEquals(msgEsperado, exception.getMessage());
    }     

}
