package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task6Test {

    @Test

    public void kaprekarSteps() {
        assertEquals(0, Task6.count(6174));
        assertEquals(3, Task6.count(1234));
        assertEquals(3, Task6.count(9876));
        assertEquals(-1, Task6.count(123));
        assertEquals(-1, Task6.count(12345));
        assertEquals(-1, Task6.count(1));
        assertEquals(-1, Task6.count(0));
        assertEquals(-1, Task6.count(-1234));
    }

}
