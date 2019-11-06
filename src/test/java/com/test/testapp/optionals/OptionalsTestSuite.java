package com.test.testapp.optionals;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class OptionalsTestSuite {
    private Optional<String> empty = Optional.empty();
    private Optional<String> nonEmpty = Optional.of("Michael!");
    private Optional<String> withNull = Optional.ofNullable(null);
    private String finalText;
    private Consumer<String> printSomething = (x) -> {
        finalText = "hi There " + x;};
    private Supplier<String> supplySomething = () -> {
        return "George!";
    };

    @Test
    void shouldSayOptionalIsNotPresent() {
        assertFalse(empty.isPresent());
        assertFalse(withNull.isPresent());
    }

    @Test
    void shouldSayOptionalIsPresent() {
        assertTrue(nonEmpty.isPresent());
    }

    @Test
    void shouldExecuteConsumerIfPresent() {
        nonEmpty.ifPresent(printSomething);
        assertEquals("hi There Michael!", finalText);
    }

    @Test
    void shouldGetValueFromOptional() {
        assertEquals("Michael!", nonEmpty.get());
    }

    @Test
    void shouldReturnDefaultValueOrActual() {
        assertEquals("Default", withNull.orElse("Default"));
        assertEquals("Michael!", nonEmpty.orElse("Default"));
    }

    @Test
    void shouldExecuteSupplierFunction() {
        assertEquals("George!", empty.orElseGet(supplySomething));
    }

    @Test
    void shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> empty.orElseThrow(IllegalArgumentException::new));
    }
}