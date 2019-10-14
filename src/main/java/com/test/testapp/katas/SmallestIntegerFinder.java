package com.test.testapp.katas;

import java.util.Arrays;

public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        return Arrays.stream(args).reduce(args[0], Math::min);
    }
}