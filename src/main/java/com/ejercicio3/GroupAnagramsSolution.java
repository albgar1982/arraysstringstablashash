package com.ejercicio3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsSolution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();

        Map<String, List<String>> anagramMap = buildAnagramMap(strs);
        return new ArrayList<>(anagramMap.values()); //Devolvemos una lista de las listas (cada valor del mapa es una lista en sí misma)
    }

    private Map<String, List<String>> buildAnagramMap(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        //Para cada palabra...
        for (String s : strs) {
            //...calculo el hash
            String hash = getAnagramHash(s);
            //si ese hash no existe como clave en el mapa...
            if (!anagramMap.containsKey(hash)) {
                //...lo añado como clave y con valor un ArrayList vacío
                anagramMap.put(hash, new ArrayList<>());
            }
            //Finalmente, añado a esa lista nueva -o preexistente-, la palabra (no el hash)
            anagramMap.get(hash).add(s);
        }

        return anagramMap;
    }

    /**
     *
     * @param s La palabra de la que vamos a devolver el código hash
     *          Un hash es una forma de convertir un dato en otro valor que actúa como "clave" o identificador. En este caso,
     *          el objetivo es convertir cada palabra en una clave única que sea idéntica para todas las palabras que son
     *          anagramas entre sí.
     * @return  Una representación de los conteos de letras como un string. Ejemplo:
     *          Para "saco": letterCount = [1, 0, 1, 0, ..., 0, 1] → "saco" y "caso" tendrán el mismo hash porque sus
     *          frecuencias son idénticas.
     */
    private String getAnagramHash(String s) {
        // Se utiliza un array de tamaño 26 (número de letras en el alfabeto inglés). Cada índice del array corresponde a una
        // letra del alfabeto (a está en el índice 0, b en el índice 1, etc.).
        int[] letterCount = new int[26];

        // Se recorre cada letra de la palabra (s.toCharArray()) y se incrementa (++) el contador en el índice correspondiente
        // del array letterCount.
        for (int c : s.toCharArray()) {
            letterCount[c - 'a']++; // El número de la letra menos 'a' que es 97 nos dará el índice de la letra en el array letterCount, al que hay que sumarle uno para contar su número de apariciones en la palabra
        }

        return Arrays.toString(letterCount); // RECUERDA: "saco" y "caso" tendrán el mismo hash
    }
}
