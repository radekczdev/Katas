package com.test.testapp.katas;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" ")).
                map(a -> a.length() > 5 ? new StringBuilder(a).reverse().toString() : a).
                collect(Collectors.joining(" "));
    }
}
