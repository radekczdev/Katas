package com.test.testapp.katas;

import java.util.*;
import java.util.stream.Collectors;

public class FindOdd {
    public static int findIt(int[] a) {
        List<Integer> numbers = Arrays.stream(a).boxed().collect(Collectors.toList());
        for(int dist : a) {
            numbers = numbers.stream().filter(element -> element != dist).collect(Collectors.toList());
            if(numbers.size() % 2 == 0)
                return dist;
        }
        return 0;
    }
}