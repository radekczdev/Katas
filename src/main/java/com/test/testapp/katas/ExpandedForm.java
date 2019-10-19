package com.test.testapp.katas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpandedForm {
    public static String expandedForm(int num) {
        List<Integer> results = new ArrayList<>();
        int divider = 10;
        while(num != 0) {
            int modulo = num % divider;
            if(modulo != 0) {
                results.add(modulo);
            }
            num = num - modulo;
            divider *= 10;
        }
        results.sort(Comparator.reverseOrder());
        return results.stream().map(String::valueOf).collect(Collectors.joining(" + "));
    }
}
