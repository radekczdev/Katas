package com.test.testapp.katas;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        for(String symbol : commentSymbols) {
            text = Arrays.stream(text.split("\n", -1)).
                    map(line -> line.replaceAll(Pattern.quote(symbol) + ".*$", "").replaceAll("\\s*$","")).
                    collect(Collectors.joining("\n"));
        }
        return text;
    }

}