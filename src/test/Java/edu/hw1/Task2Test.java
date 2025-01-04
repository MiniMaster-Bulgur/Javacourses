package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task2Test {

    @Test

    public void testrazradInput() {
        assertEquals(1, Task2.razrad(0));
        assertEquals(3, Task2.razrad(123));
        assertEquals(10, Task2.razrad(1928374656));
        assertEquals(2, Task2.razrad(87));
        assertEquals(1, Task2.razrad(-1));
        assertEquals(5, Task2.razrad(43567));
    }

}
