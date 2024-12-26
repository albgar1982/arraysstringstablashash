package com.ejercicio1;

import java.util.HashSet;
import java.util.Set;

public class IsUniqueSolution {

    // Asumiendo que es ASCII. Dependiendo de la codificación serán más
    private static final int NUMBER_OF_CHARS = 128;

    public boolean isUnique(String s) {
        if (s.length() > NUMBER_OF_CHARS) return false; //Una sola comprobación -> O(1) Complejidad CTE
        //No tenemos por qué comprobar nada; si el String mide más que el número total de chars existentes,
        //significa que tiene repetidos

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return false; //No es necesario meterlo si ya está, es innecesario!!!
            set.add(c);
        }

        return true;
    }
}
/*
MUY IMPORTANTE memorizar el método de los String toCharArray(), que hace que podamos meterlo en un char[] o iterarlo en
forEach como en este ejemplo
 */