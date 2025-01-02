package com.ejercicio2;

import java.util.*;

public class TwoSumV2 {

    /**
     * Encuentra los índices de dos números en el array que suman la cantidad especificada.
     * Lanza IllegalArgumentException si el array es nulo o está vacío.
     *
     * @param arrayNumerico el array de números
     * @param sumaEsperada la suma esperada
     * @return un array con los índices de los dos números, o null si no se encuentran
     * @throws IllegalArgumentException si el array es nulo o está vacío
     */
    @SuppressWarnings("ConstantConditions")
    public int[] twoSum(int[] arrayNumerico, int sumaEsperada){

        // Validar si el array es nulo o está vacío
        if (arrayNumerico == null || arrayNumerico.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío.");
        }

        //En este mapa guardaremos como clave el valor a buscar para completar la suma
        Map<Integer, Integer> visited = new HashMap<>();

        int num, diferencia;
        for (int i = 0; i < arrayNumerico.length; i++) {
            num = arrayNumerico[i];
            diferencia = sumaEsperada - num;
            if (visited.containsKey(diferencia)) {
                return new int[]{visited.get(diferencia), i};
            }
            visited.put(num, i);
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSumV2 twoSum = new TwoSumV2();

        int[] arrayPrueba = new Random().ints(1000, 0, 1000).toArray();

        // Capturar el tiempo de inicio
        long comienzo = System.nanoTime();

        System.out.println(Arrays.toString(twoSum.twoSum(arrayPrueba, 7)));

        // Capturar el tiempo de fin
        long fin = System.nanoTime();

        // Calcular el tiempo transcurrido
        long duracion = fin - comienzo;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + duracion + " nanosegundos");

        try {
            System.out.println(Arrays.toString(twoSum.twoSum(null, 7)));
        }
        catch (IllegalArgumentException illegalArgumentException){
            System.out.println(illegalArgumentException.getMessage());
        }

    }
}
/*
Esta versión tiene una complejidad lineal O(N), ya que solo se recorre el array una vez.
 */