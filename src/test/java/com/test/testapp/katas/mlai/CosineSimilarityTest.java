package com.test.testapp.katas.mlai;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.test.testapp.katas.mlai.CosineSimilarity.calculateCosineSimilarity;

public class CosineSimilarityTest {

    @Test
    public void cosineSimilarity() {
        ArrayList<Integer> x_keys = new ArrayList<>(List.of(2, 3, 4, 5, 6));
        ArrayList<Double> x_vals = new ArrayList<>(List.of(1.0, 1.0, 1.0, 1.0, 1.0));
        ArrayList<Integer> y_keys = new ArrayList<>(List.of(1, 2, 3, 7));
        ArrayList<Double> y_vals = new ArrayList<>(List.of(1.0, 1.0, 1.0, 1.0));

        calculateCosineSimilarity(x_keys, x_vals, y_keys, y_vals);
    }

}