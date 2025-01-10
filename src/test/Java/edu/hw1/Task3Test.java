package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task3Test {

    @Test

    public void minMax() {
        assertTrue(Task3.minMax(new int[]{3, 4, 5}, new int[]{1, 2, 6, 7}));
        assertTrue(Task3.minMax(new int[]{10, 11, 12}, new int[]{5, 6, 13, 14}));
        assertFalse( Task3.minMax(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        assertFalse(Task3.minMax(new int[]{5, 6, 7}, new int[]{1, 2, 3}));
        assertTrue( Task3.minMax(new int[]{5}, new int[]{1, 10}));
        assertTrue(Task3.minMax(new int[]{}, new int[]{1, 2, 3}));
        assertFalse(Task3.minMax(new int[]{1, 2, 3}, new int[]{}));
        assertFalse(Task3.minMax(new int[]{}, new int[]{}));
        assertTrue(Task3.minMax(new int[]{5, 5, 5}, new int[]{1, 10, 10}));
    }

}
