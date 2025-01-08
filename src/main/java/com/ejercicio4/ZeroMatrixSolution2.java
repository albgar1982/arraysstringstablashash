package com.ejercicio4;

import java.util.Arrays;

public class ZeroMatrixSolution2 {

    public void matrizCero(int[][] matriz) {
        boolean primeraFilaTieneCero = tieneCeroEnPrimeraFila(matriz); //Guardamos esta info para modificar toda la fila al final si es necesario,
        //ya que vamos a usar la primera fila como marcador auxiliar que indique qué columnas tenemos que llenar con ceros. Una vez que hagamos eso, ya no
        //podremos comprobar sus elementos para saber si hay algún cero o no, de ahí este booleano.
        boolean primeraColumnaTieneCero = tieneCeroEnPrimeraColumna(matriz); //Guardamos esta info para modificar toda la columna al final si es necesario,
        //ya que vamos a usar la primera columna como marcador auxiliar que indique qué filas tenemos que llenar con ceros. Una vez que hagamos eso, ya no
        //podremos comprobar sus elementos para saber si hay algún cero o no, de ahí este booleano.

        // Comprobamos los ceros en el resto de la matriz.
        comprobarCeros(matriz);

        // Procesamos las filas y columnas con ceros.
        procesarFilas(matriz);
        procesarColumnas(matriz);

        // Si la primera fila o columna tenía un cero, debemos procesarlas también.
        if (primeraFilaTieneCero) {
            ponerFilaACero(matriz, 0);
        }

        if (primeraColumnaTieneCero) {
            ponerColumnaACero(matriz, 0);
        }
    }

    private boolean tieneCeroEnPrimeraFila(int[][] matriz) {
        return Arrays.stream(matriz[0]).anyMatch(x -> x == 0);
    }

    private boolean tieneCeroEnPrimeraColumna(int[][] matriz) {
        return Arrays.stream(matriz).anyMatch(fila -> fila[0] == 0);
    }

    /*
     * Si encontramos un cero en [fila][columna], escribimos un cero en la fila 'fila' de la primera columna y en la
     * columna 'columna' de la primera fila. Así marcamos que la fila y la columna deben ser procesadas.
     */
    private void comprobarCeros(int[][] matriz) {
        for (int fila = 1; fila < matriz.length; fila++) {
            for (int columna = 1; columna < matriz[0].length; columna++) {
                if (matriz[fila][columna] == 0) {
                    matriz[fila][0] = 0;
                    matriz[0][columna] = 0;
                }
            }
        }
    }

    /**
     * Procesa las filas de la matriz y pone en ceros aquellas cuya primera posición es 0.
     *
     * @param matriz La matriz que se va a procesar.
     */
    private void procesarFilas(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            if (matriz[fila][0] == 0) {
                ponerFilaACero(matriz, fila);
            }
        }
    }

    /**
     * Establece todos los elementos de una fila específica a 0.
     *
     * @param matriz La matriz en la que se modificará la fila.
     * @param fila El índice de la fila que será puesta a cero.
     */
    private void ponerFilaACero(int[][] matriz, int fila) {
        for (int columna = 0; columna < matriz[0].length; columna++) {
            matriz[fila][columna] = 0;
        }
    }

    /**
     * Procesa las columnas de la matriz y pone en ceros aquellas cuya primera posición es 0.
     *
     * @param matriz La matriz que se va a procesar.
     */
    private void procesarColumnas(int[][] matriz) {
        for (int columna = 0; columna < matriz[0].length; columna++) {
            if (matriz[0][columna] == 0) {
                ponerColumnaACero(matriz, columna);
            }
        }
    }

    /**
     * Establece todos los elementos de una columna específica a 0.
     *
     * @param matriz La matriz en la que se modificará la columna.
     * @param columna El índice de la columna que será puesta a cero.
     */
    private void ponerColumnaACero(int[][] matriz, int columna) {
        for (int fila = 0; fila < matriz.length; fila++) {
            matriz[fila][columna] = 0;
        }
    }

}

