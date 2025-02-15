package edu.hw1;

import edu.hw1.Task7;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void testRotateLeft() {
        assertEquals(16, Task7.rotateLeft(8, 1));  // 8 is 0000...1000 -> 0001...0000 (16 in decimal)
        assertEquals(1, Task7.rotateLeft(1, 32));  // Same rotation as input
        assertEquals(4, Task7.rotateLeft(1, 2));   // Rotate 1 two positions left
    }

    @Test
    void testRotateRight() {
        assertEquals(4, Task7.rotateRight(8, 1));  // 8 is 0000...1000 -> 0000...0100 (4 in decimal)
        assertEquals(1, Task7.rotateRight(1, 32)); // Same rotation as input
        assertEquals(Integer.MIN_VALUE >>> 1, Task7.rotateRight(0, 1)); // Rotate 0 right by 1
    }
}
