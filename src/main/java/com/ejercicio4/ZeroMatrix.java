package com.ejercicio4;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

    public static void main(String[] args) {
        ZeroMatrix zeroMatrix = new ZeroMatrix();
        int[][] matriz = {
                {2, 1, 3, 0, 2},
                {7, 4, 1, 3, 8},
                {4, 0, 1, 2, 1},
                {9, 3, 4, 1, 9}
        };

        matriz = zeroMatrix.zeroMatrix(matriz);

        for (int[] ints : matriz) {
            System.out.print("{");
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j]);
                if (j < ints.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("},");
        }
    }

    public int[][] zeroMatrix(int[][] matrix) {
        // Almacenar las filas y columnas que deben ser puestas a cero
        Set<Integer> filasConCero = new HashSet<>();
        Set<Integer> columnasConCero = new HashSet<>();

        // Primera pasada: identificar filas y columnas que contienen ceros
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    filasConCero.add(i);
                    columnasConCero.add(j);
                }
            }
        }

        // Segunda pasada: establecer ceros en las filas y columnas identificadas
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (filasConCero.contains(i) || columnasConCero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
}
