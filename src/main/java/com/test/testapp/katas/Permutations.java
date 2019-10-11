package com.test.testapp.katas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Permutations {

    public static List<String> singlePermutations(String s) {
        Set<String> setOfResults = new HashSet<>();
        char[] sArray = s.toCharArray();
        setOfResults.add(s);
        int numberOfCharacters = s.length();
        int numberOfPermutations = factorial(numberOfCharacters);
        for(int i=0; i < numberOfPermutations; i++) {
            for(int j=0; j < numberOfCharacters - 1; j++) {
                char atJ = sArray[j];
                sArray[j] = sArray[j+1];
                sArray[j+1] = atJ;
                setOfResults.add(String.valueOf(sArray));
            }

        }
        return new ArrayList<>(setOfResults);
    }

    private static int factorial(int number) {
        return number == 1 ? number : number*factorial(--number);
    }

}