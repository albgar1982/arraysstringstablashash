package com.ejercicio2;

import java.util.Arrays;
import java.util.Random;

/*
inputs:
    -Un array de números enteros
    -Un número entero que es el resultado de la suma de dos de los números del array

output -> Se espera como salida los índices de los 2 números del array que sumen entre ellos el número
que nos dan como resultado

Puede que no haya ninguna solución, entonces devolver null
Asumimos que solo hay una solución posible (una combinación que da la suma, no varias)
 */
public class TwoSum {

    public int[] twoSum(int[] arrayNumerico, int sumaEsperada){

        for(int i = 0; i < arrayNumerico.length -1; i++){
            for(int j = i + 1; j < arrayNumerico.length; j++){
                if(arrayNumerico[i] + arrayNumerico[j] == sumaEsperada)
                    return new int[]{arrayNumerico[i], arrayNumerico[j]};
            }
        }
        return null;
    }

    public static void main(String[] args) {

        int[] arrayPrueba = new int[1000];
        Random random = new Random();
        // Rellenar el array con números aleatorios entre 0 y 999
        arrayPrueba = Arrays.stream(arrayPrueba)
                .map(num -> random.nextInt(1000))  // Reemplaza cada valor por un número aleatorio
                .toArray();  // Convierte el stream de nuevo a un array

        TwoSum twoSum = new TwoSum();

        // Capturar el tiempo de inicio
        long startTime = System.nanoTime();

        System.out.println(Arrays.toString(twoSum.twoSum(arrayPrueba, 7)));

        // Capturar el tiempo de fin
        long endTime = System.nanoTime();

        // Calcular el tiempo transcurrido
        long duration = endTime - startTime;

        // Imprimir el tiempo en nanosegundos
        System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
    }
}
/*
Esta versión tiene una complejidad cuadrática O(N^2)
 */