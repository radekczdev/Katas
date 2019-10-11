package com.test.testapp.katas;

import java.util.Arrays;
import java.util.stream.Stream;

public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        return  Stream.of(array1).filter(a -> Arrays.stream(array2).anyMatch(b -> b.contains(a))).sorted().toArray(String[]::new);
    }
}
