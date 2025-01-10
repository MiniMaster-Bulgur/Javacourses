package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {

    @Test

    public void testminutesToSecondsValidInput(){
        assertEquals(120, Task1.minutesToSeconds("02:00"));
        assertEquals(705, Task1.minutesToSeconds("11:45"));
        assertEquals(1418, Task1.minutesToSeconds("23:38"));
        assertEquals(-1, Task1.minutesToSeconds("02:767"));
        assertEquals(-1, Task1.minutesToSeconds("02:dr00"));
        assertEquals(-1, Task1.minutesToSeconds("as45spasite"));
    }
}
