package com.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10,
                calculator.add(5, 5));
    }

    @Test
    void testSubtract() {
        assertEquals(2,
                calculator.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15,
                calculator.multiply(3, 5));
    }
}
