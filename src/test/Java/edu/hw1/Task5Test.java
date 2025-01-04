package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task5Test {

    @Test

public void fixString() {
    assertFalse(Task5.isPalindromeDescendant(1));
    assertFalse(Task5.isPalindromeDescendant(9));
    assertTrue(Task5.isPalindromeDescendant(121));
    assertTrue(Task5.isPalindromeDescendant(12321));
    assertFalse(Task5.isPalindromeDescendant(123));
    assertFalse(Task5.isPalindromeDescendant(12345));
}

}
