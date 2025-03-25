package edu.hw1;

import edu.hw1.Task5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void testIsPalindromeDescendantTrue() {
        assertTrue(Task5.isPalindromeDescendant(23336014));
    }

    @Test
    void testIsPalindromeDescendantFalse() {
        assertFalse(Task5.isPalindromeDescendant(12));
    }

    @Test
    void testIsPalindromeDescendantSingleDigit() {
        assertTrue(Task5.isPalindromeDescendant(8)); // Однозначное число - палиндром
    }

    @Test
    void testIsPalindromeDescendantPalindrome() {
        assertTrue(Task5.isPalindromeDescendant(1221)); // Уже палиндром
    }

    @Test
    void testIsPalindromeDescendantNoDescendant() {
        assertFalse(Task5.isPalindromeDescendant(123456)); // Нет потомка-палиндрома
    }
}
