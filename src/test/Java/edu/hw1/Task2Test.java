package edu.hw1;

import edu.hw1.Task2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void testZero() {
        assertEquals(1, Task2.countDigits(0));
    }

    @Test
    void testPositiveNumber() {
        assertEquals(3, Task2.countDigits(233));
    }

    @Test
    void testNegativeNumber() {
        assertEquals(3, Task2.countDigits(-233));
    }

    @Test
    void testSingleDigit() {
        assertEquals(1, Task2.countDigits(7));
    }

    @Test
    void testLargeNumber() {
        assertEquals(10, Task2.countDigits(1234567890));
    }
}
