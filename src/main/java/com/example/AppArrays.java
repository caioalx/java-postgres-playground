package com.example;

import java.util.Arrays;

public class AppArrays {
    
    public static void main(String[] args) {
        
        double vetorDouble[] = {10,20,30};
        vetorDouble[0] = 1;
        
        for (int i = 0; i < vetorDouble.length; i++) {
            vetorDouble[i] = 100 * (i+1);
        }

        //System.out.println(Arrays.toString(vetorDouble));

        int vetorInt[] = new int[4];
        vetorInt[0] = 100;
        vetorInt[1] = 200;
        vetorInt[2] = 300;
        vetorInt[3] = 400;
        //System.out.println(Arrays.toString(vetorInt));

        double matriz[][] = {{10,20},{30,40},{50,60}};
        matriz[0] = new double[]{0,1,2};
        //System.out.println(Arrays.toString(matriz[0]));

        double matriz2[][] = new double[2][3];
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                matriz2[i][j] = (i * matriz2[i].length + j+1) * 10;
            }
        }

        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.printf("%5.1f ",matriz2[i][j]);
            }
            System.out.println();
        }        

    }

}
