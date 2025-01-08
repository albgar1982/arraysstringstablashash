package com.ejercicio4;

public class ZeroMatrixSolution {

    public void zeroMatrix(int[][] matrix) {
        boolean firstRowHasZero = hasFirstRowAnyZeroes(matrix);
        boolean firstColHasZero = hasFirstColAnyZeroes(matrix);

        // Comprobamos los ceros en el resto de la matriz.
        checkForZeroes(matrix);

        processRows(matrix);
        processColumns(matrix);

        // Si la primera fila o columna tenía un cero, debemos procesarlas también.
        if (firstRowHasZero) {
            setRowToZero(matrix, 0);
        }

        if (firstColHasZero) {
            setColToZero(matrix, 0);
        }
    }

    private boolean hasFirstRowAnyZeroes(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean hasFirstColAnyZeroes(int[][] matrix) {
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                return true;
            }
        }
        return false;
    }

    /*
     * Si encontramos un cero en F:C, escribimos un cero en la fila F de la primera columna y en la
     * columna C de la primera fila. Así marcamos que la fila y la columna debe ser procesada.
     */
    private void checkForZeroes(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
    }

    private void processRows(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                setRowToZero(matrix, row);
            }
        }
    }

    private void setRowToZero(int[][] matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }

    private void processColumns(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                setColToZero(matrix, col);
            }
        }
    }

    private void setColToZero(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }
}