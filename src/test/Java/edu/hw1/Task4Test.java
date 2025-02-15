package edu.hw1;

import edu.hw1.Task4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void testEvenLengthString() {
        assertEquals("кошка", Task4.fixString("оккша"));
    }

    @Test
    void testOddLengthString() {
        assertEquals("абвгде", Task4.fixString("бавгде"));
    }

    @Test
    void testSingleCharacterString() {
        assertEquals("А", Task4.fixString("А"));
    }

    @Test
    void testEmptyString() {
        assertEquals("", Task4.fixString(""));
    }

    @Test
    void testSameCharactersString() {
        assertEquals("аабб", Task4.fixString("аабб"));
    }
}
