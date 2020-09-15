package com.test.testapp;

import lombok.Getter;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

@Getter
public class TestApp {
    private static final Logger logger = Logger.getLogger("TestApp");

    public static void main(String[] args) {
        logger.info("Hello World!");
        IntStream.range(-5, 10).forEach(a -> logger.info("factorial of: " + a + " " + factorial(a)));
        String doubleSum = String.valueOf(doublePrecision(10));
        String result = MessageFormat.format("Cumulative sum of 0.1: {0} ", doubleSum);
        logger.log(Level.INFO, result);
    }

    private static double doublePrecision(int times) {
        double base = 0.1;
        double sum = 0.0;
        for (int i = 0; i < times; i++) {
            double v = base;
            sum += v;
        }
        return sum;
    }

    private static int factorial(int max) {
        if(max < 1) {
            return 1;
        }
        return max * factorial(max-1);
    }
}
