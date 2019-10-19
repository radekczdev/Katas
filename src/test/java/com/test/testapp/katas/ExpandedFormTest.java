package com.test.testapp.katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpandedFormTest {
    @Test
    public void testSomething() {
        assertEquals("10 + 2", ExpandedForm.expandedForm(12));
        assertEquals("40 + 2", ExpandedForm.expandedForm(42));
        assertEquals("70000 + 300 + 4", ExpandedForm.expandedForm(70304));
        assertEquals("4000000 + 900000 + 80000 + 2000 + 300 + 40 + 2", ExpandedForm.expandedForm(4982342));
    }
}