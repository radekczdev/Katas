package com.test.testapp.katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        Map<Integer, String> signs = new HashMap<>();
        signs.put(0, "(");
        signs.put(4, ")");
        signs.put(5, " ");
        signs.put(9, "-");
        List<String> digits = IntStream.of(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
        signs.forEach(digits::add);
        return String.join("", digits);
    }
}
