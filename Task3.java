package ru.zotin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));  // true
        System.out.println(fuzzySearch("cwhl", "cartwheel"));      // true
        System.out.println(fuzzySearch("cwhee", "cartwheel"));     // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));   // false
        System.out.println(fuzzySearch("lw", "cartwheel"));        // false
    }

    private static boolean fuzzySearch(String car, String s) {
        int index = 0;

        char[] firstWord = car.toCharArray();
        char[] secondWord = s.toCharArray();
        for (int i = 0; i < secondWord.length; i++) {
            if (firstWord[index] == secondWord[i]) {
                index++;
            }
            if (index == firstWord.length) {
                return true;
            }
        }
        return false;
    }
}
