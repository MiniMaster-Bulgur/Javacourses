package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void testValidInput() {
        assertEquals(104 * 60 + 23, Task1.minutesToSeconds("104:23"));
    }

    @Test
    void testInvalidInputNoColon() {
        assertEquals(-1, Task1.minutesToSeconds("10423"));
    }

    @Test
    void testInvalidInputNonNumeric() {
        assertEquals(-1, Task1.minutesToSeconds("104:aa"));
    }

    @Test
    void testInvalidSecondsOver59() {
        assertEquals(-1, Task1.minutesToSeconds("10:60"));
    }

    @Test
    void testNegativeMinutes() {
        assertEquals(-1, Task1.minutesToSeconds("-1:20"));
    }

    @Test
    void testNegativeSeconds() {
        assertEquals(-1, Task1.minutesToSeconds("10:-20"));
    }

    @Test
    void testZeroValues() {
        assertEquals(0, Task1.minutesToSeconds("0:0"));
    }
}
