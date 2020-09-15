package com.test.testapp.katas;

import java.util.*;
import java.util.stream.Collectors;

public class Kata {
    public static double findUniq(double[] arr) {
        List<Double> listOfVals = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Double> unique = new HashSet<>(listOfVals);
        for(Double a : unique) {
            listOfVals.remove(a);
            if(!listOfVals.remove(a)) {
                return a;
            }
        }
        return arr[0];
    }

    public static double findUniq1(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }
}
