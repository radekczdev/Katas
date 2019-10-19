package com.test.testapp.katas;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateEncoder {
    static String encode(String word){
        String finalWord = word.toLowerCase();
        return Stream.of(finalWord.split("")).
                map(a ->
                        finalWord.indexOf(a) == finalWord.lastIndexOf(a) ? "(" : ")"
                ).
                collect(Collectors.joining(""));
    }
}
