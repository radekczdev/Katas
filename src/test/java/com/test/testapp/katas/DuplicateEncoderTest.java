package com.test.testapp.katas;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class DuplicateEncoderTest {
    @Test
    public void test() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encode("   ()(   "));
    }
}