package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

    public class Task6Test {

        @Test
        public void testCountK() {
            assertEquals(3, Task6.countK(3524));
            assertEquals(5, Task6.countK(6621));
            assertEquals(4, Task6.countK(6554));
            assertEquals(3, Task6.countK(1234));
        }

        @Test
        public void testCountKWithSingleDigit() {
            assertEquals(0, Task6.countK(6174)); // 6174 is the Kaprekar constant, so it should return 0 steps
        }

        @Test
        public void testCountKWithAllSameDigits() {
            assertEquals(8, Task6.countK(1111)); // All digits are the same, should return 8 steps
        }

        @Test
        public void testCountKWithMinimumValue() {
            assertEquals(5, Task6.countK(1000)); // Minimum 4-digit number
        }

        @Test
        public void testCountKWithMaximumValue() {
            assertEquals(7, Task6.countK(9999)); // Maximum 4-digit number
        }
    }
