package com.test.testapp.katas;

import com.test.testapp.katas.Kata;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    private final double precision = 0.0000000000001;
    @Test
    void findUniq() {
        assertEquals(2.0, Kata.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
    @Test
    void findUniq1() {
        assertEquals(2.0, Kata.findUniq1(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
}