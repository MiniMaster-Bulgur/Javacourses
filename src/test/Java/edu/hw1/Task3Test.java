package edu.hw1;

import edu.hw1.Task3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void testNestable() {
        assertTrue(Task3.isNestable(new int[]{2, 1, 1, 2}, new int[]{0, 3}));
    }

    @Test
    void testNotNestable() {
        assertFalse(Task3.isNestable(new int[]{0, 1, 2}, new int[]{1, 2}));
    }

    @Test
    void testEqualArrays() {
        assertFalse(Task3.isNestable(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    @Test
    void testSingleElementArrays() {
        assertFalse(Task3.isNestable(new int[]{2}, new int[]{2}));
    }

    @Test
    void testEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Task3.isNestable(new int[]{}, new int[]{1, 2, 3});
        });
    }
}
