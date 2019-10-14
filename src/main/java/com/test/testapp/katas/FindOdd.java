package com.test.testapp.katas;

import java.util.*;
import java.util.stream.Collectors;

public class FindOdd {
    public static int findIt(int[] a) {
        List<Integer> numbers = Arrays.stream(a).boxed().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        for(int dist : a) {

            List<Integer> toBeRemoved = new ArrayList<>();
            toBeRemoved.add(dist);
            numbers.removeAll(toBeRemoved);
            if(numbers.size() % 2 == 0)
                return dist;
        }
        return 0;
    }
}