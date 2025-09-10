package com.test.testapp.katas.mlai;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.IntStream;

public class CosineSimilarity {
    public static double calculateCosineSimilarity(List<Integer> xKeys, List<Double> xVals, List<Integer> yKeys, List<Double> yVals) {
        int maxLength = Math.max(xKeys.size(), yKeys.size());
        BigDecimal modProduct = IntStream.rangeClosed(0, maxLength).mapToDouble(i -> {
                    Integer indexOfCurrentXPosition = xKeys.contains(i) ? xKeys.indexOf(i) : null;
                    Integer indexOfCurrentYPosition = yKeys.contains(i) ? yKeys.indexOf(i) : null;
                    return (indexOfCurrentXPosition == null ? 0 : xVals.get(indexOfCurrentXPosition)) *
                            (indexOfCurrentYPosition == null ? 0 : yVals.get(indexOfCurrentYPosition));
                }
        ).mapToObj(BigDecimal::valueOf).reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal sqrtAiSquare = BigDecimal.valueOf(xVals.stream().mapToDouble(x -> x * x).sum()).sqrt(MathContext.DECIMAL128);
        BigDecimal sqrtBiSquare = BigDecimal.valueOf(yVals.stream().mapToDouble(y -> y * y).sum()).sqrt(MathContext.DECIMAL128);
        BigDecimal v = modProduct.divide(sqrtAiSquare.multiply(sqrtBiSquare), MathContext.DECIMAL128);
        System.out.println(v.toPlainString());
        return v.doubleValue();
    }
}
