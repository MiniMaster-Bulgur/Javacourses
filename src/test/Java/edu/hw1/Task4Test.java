package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Task4Test {


@Test

public void fixString() {
    assertEquals("12345678", Task4.fixString("21436587"));
    assertEquals("привет", Task4.fixString("рпвите"));
    assertEquals("кошка", Task4.fixString("оккша"));
    assertEquals("1", Task4.fixString("1"));
    assertEquals("", Task4.fixString(""));
    assertEquals("1й2ц3у", Task4.fixString("й1ц2у3"));
    }

}
