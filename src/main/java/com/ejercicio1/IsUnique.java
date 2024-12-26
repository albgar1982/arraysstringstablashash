package com.ejercicio1;

import java.util.HashSet;

/*
 * Dado un método que recibe un String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 */
public class IsUnique {

    public static void main(String[] args) {
        IsUnique esUnico = new IsUnique();
        System.out.println(esUnico.isUnique(""));
    }

    public boolean isUnique(String s) {

        HashSet<Character> hashSet = new HashSet<>();
        int tamanioHashSet = 0;
        for(int i = 0; i < s.length(); i++){
            hashSet.add(s.charAt(i));
            if(tamanioHashSet == hashSet.size())
                return false;
            else
                tamanioHashSet = hashSet.size();
        }
        return true;
    }
}


