package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import proect.proect1.Game;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        game = new Game();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testGameInitialization() {
        assertNotNull(game);
    }

    @Test
    @Timeout(5) // 5 секунд таймаут
    void testGamePlayWithExit() {
        String input = "E\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(SecurityException.class, () -> game.start());
    }

    @Test
    void testGamePlayWithNewGame() {
        String input = "N\nа\nб\nв\nг\nд\nе\nE\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(SecurityException.class, () -> game.start());

        String output = outContent.toString();
        assertTrue(output.contains("Welcome to Hangman!"));
        assertTrue(output.contains("Word length:"));
    }

    @Test
    void testInvalidMenuOption() {
        String input = "X\nE\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(SecurityException.class, () -> game.start());

        String output = outContent.toString();
        assertTrue(output.contains("Invalid option"));
    }

}
