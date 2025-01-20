package proect.proect1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordMaskOperatorTest {
    private WordMaskOperator maskOperator;

    @BeforeEach
    void setUp() {
        maskOperator = new WordMaskOperator();
        maskOperator.setWord("testing");
    }

    @Test
    void testSetWord() {
        maskOperator.setWord("hello");
        assertFalse(maskOperator.userWon());
        assertEquals(0, maskOperator.getCorrectGuessCount());
    }

    @Test
    void testContainsLetter() {
        assertTrue(maskOperator.containsLetter("t"));
        assertFalse(maskOperator.containsLetter("x"));
    }

    @Test
    void testLetterUsage() {
        maskOperator.useUserInputLetter("t");
        assertTrue(maskOperator.isLetterAlreadyUsed("t"));
        assertFalse(maskOperator.isLetterAlreadyUsed("e"));
    }

    @Test
    void testUpdateMask() {
        maskOperator.updateMask("t");
        assertTrue(maskOperator.isLetterAlreadyUsed("t"));
        assertFalse(maskOperator.userWon());
    }

    @Test
    void testWinCondition() {
        String[] letters = "testing".split("");
        for (String letter : letters) {
            maskOperator.useUserInputLetter(letter);
            maskOperator.updateMask(letter);
        }
        assertTrue(maskOperator.userWon());
    }

    @Test
    void testClearBuffer() {
        maskOperator.useUserInputLetter("t");
        maskOperator.clearBuffer();
        assertFalse(maskOperator.isLetterAlreadyUsed("t"));
        assertEquals(0, maskOperator.getCorrectGuessCount());
    }

    @Test
    void testCaseInsensitivity() {
        maskOperator.useUserInputLetter("T");
        assertTrue(maskOperator.isLetterAlreadyUsed("t"));
        assertTrue(maskOperator.isLetterAlreadyUsed("T"));
    }
}
