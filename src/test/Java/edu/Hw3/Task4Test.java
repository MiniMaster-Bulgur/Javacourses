package edu.Hw3;

import edu.hw3.Task4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    @Test
    void testConvertToRoman() {

        assertEquals("II", Task4.convertToRoman(2));
        assertEquals("XII", Task4.convertToRoman(12));
        assertEquals("XVI", Task4.convertToRoman(16));

        assertEquals("IV", Task4.convertToRoman(4));
        assertEquals("IX", Task4.convertToRoman(9));
        assertEquals("MCMXCIX", Task4.convertToRoman(1999));

        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(0));
        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(4000));
    }
}
