package com.ejercicio3;

import java.util.*;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados. Cualquier orden es válido.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"].
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 */
public class AnagramasAgrupados {

    public void groupAnagrams(String[] words) {
        List<List<String>> returnList = new ArrayList<>(); //El compilador infiere el tipo de ArrayList, que en este caso será de ArrayList<String>
        List<Character> characterArrayList = new ArrayList<>(
                Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                        'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r',
                        's', 't', 'u', 'v','w', 'x', 'y', 'z'));
        Map<String, byte[]> mapa = new HashMap<>();

        for(String word : words){
            byte[] listaNumeros = new byte[26];
            for(int i = 0; i < word.length(); i ++){
                char letra = word.charAt(i);
                if(characterArrayList.contains(letra))
                    listaNumeros[characterArrayList.indexOf(letra)]++;
            }
            mapa.put(word,listaNumeros);
        }

        List<String> claves = new ArrayList<>(mapa.keySet());
        // Recorrer el mapa con dos bucles para combinar cada clave con las siguientes
        for (int i = 0; i < mapa.size(); i++) {
            List<String> stringList = new ArrayList<>();
            String claveActual = claves.get(i);
            stringList.add(claveActual);
            byte[] valorActual = mapa.get(claveActual);

            for (int j = i + 1; j < claves.size(); j++) {
                String siguienteClave = claves.get(j);
                byte[] siguienteValor = mapa.get(siguienteClave);
                if(Arrays.equals(valorActual, siguienteValor)) {
                    stringList.add(siguienteClave);
                    mapa.remove(claveActual);
                }
            }
            returnList.add(stringList);
        }

        System.out.println("Lista:");
        for (List<String> lista : returnList) {
            for (int j = 0; j < lista.size(); j++) {
                System.out.print(lista.get(j));
                if (j < lista.size() - 1)
                    System.out.print(", "); // Agregar coma si no es el último elemento
            }
            System.out.println(); // Salto de línea después de cada lista
        }
    }

    public static void main(String[] args) {
        AnagramasAgrupados anagramasAgrupados = new AnagramasAgrupados();
        anagramasAgrupados.groupAnagrams(new String[]{"saco", "arresto", "programa", "rastreo", "caso"});
    }
}