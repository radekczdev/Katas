package com.test.testapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticBlocksTest {
    private final StaticBlocks blocks = new StaticBlocks();

    @Test
    void shouldReturnNumberValue() {
        // Given
        // When
        int result = blocks.getNumber();

        // Then
        assertEquals(4, result);
    }

}