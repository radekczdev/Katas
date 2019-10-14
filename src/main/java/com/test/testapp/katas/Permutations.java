package com.test.testapp.katas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Permutations {
    private static Set<String> setOfResults;

    public static List<String> singlePermutations(String s) {
        setOfResults = new HashSet<>();
        permutate("", s);
        return new ArrayList<>(setOfResults);
    }

    private static void permutate(String start, String text) {
        int length = text.length();
        if(length == 0) {
            setOfResults.add(start);
        }
        for(int i=0; i < length; i++) {
            permutate(start + text.charAt(i), text.substring(0, i) + text.substring(i+1, length));
        }
    }

//    private static int factorial(int number) {
//        return number == 1 ? number : number*factorial(--number);
//    }

}