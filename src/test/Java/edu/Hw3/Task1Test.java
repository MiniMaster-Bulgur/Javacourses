package edu.Hw3;

    import edu.hw3.Task1;
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
        @Test
        void testBasicEncryption() {
            assertEquals("Svool dliow!", Task1.atbash("Hello world!"));
        }

        @Test
        void testAllUpperCase() {
            assertEquals("ZYX", Task1.atbash("ABC"));
        }

        @Test
        void testAllLowerCase() {
            assertEquals("zyx", Task1.atbash("abc"));
        }

        @Test
        void testMixedCase() {
            assertEquals("Zmb", Task1.atbash("Any"));
        }

        @Test
        void testWithNumbers() {
            assertEquals("123", Task1.atbash("123"));
        }

        @Test
        void testEmptyString() {
            assertEquals("", Task1.atbash(""));
        }

        @Test
        void testNullInput() {
            assertEquals("", Task1.atbash(null));
        }

        @Test
        void testSpecialCharacters() {
            assertEquals("z!y@x#", Task1.atbash("a!b@c#"));
        }

        @Test
        void testLongSentence() {
            String input = "Any fool can write code that a computer can understand.";
            String expected = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw.";
            assertEquals(expected, Task1.atbash(input));
        }
    }

