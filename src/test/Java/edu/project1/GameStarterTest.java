package edu.project1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class GameStarterTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final static String EXIT_COMMAND = "E\n";

@BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

@Test
    void testMainMethodStartsGame() {
        // Подготовка входных данных для немедленного выхода
        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));

        assertThrows(SecurityException.class, () -> GameStarter.main(new String[]{}));

        String output = outputStream.toString();
        assertTrue(output.contains("Welcome to Hangman!"),
            "Game should display welcome message");
    }

@Test
    void testGameInitialization() {
        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));

        assertDoesNotThrow(() -> GameStarter.main(new String[]{}), "Game initialization should not throw exceptions");
    }

@Test
    void testMainMethodWithNullArguments() {
        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));

        assertDoesNotThrow(() -> GameStarter.main(null), "Main method should handle null arguments");
    }

@Test
    void testMainMethodWithEmptyArguments() {
        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));

        assertDoesNotThrow(() -> GameStarter.main(new String[]{}), "Main method should handle empty arguments array");
    }

@Test
    void testMainMethodWithArguments() {
        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));

        assertDoesNotThrow(() -> GameStarter.main(new String[]{"test", "arguments"}), "Main method should ignore provided arguments");
    }

@Test
    void testCompleteGameFlow() {
        // Симулируем игру с новой игрой и выходом
        String input = "N\nE\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(SecurityException.class, () -> GameStarter.main(new String[]{}));

        String output = outputStream.toString();
        assertTrue(output.contains("Welcome to Hangman!"),
            "Game should display welcome message");
        assertTrue(output.contains("Word length:"),
            "Game should display word length");
    }

@Test
    void testMultipleGameStarts() {
    {
        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));
        outputStream.reset();

        assertThrows(SecurityException.class, () -> GameStarter.main(new String[] {}));

        String output = outputStream.toString();
        assertTrue(
            output.contains("Welcome to Hangman!"),
            "Game should start correctly on attempt " + (1)
        );
    }
    {
        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));
        outputStream.reset();

        assertThrows(SecurityException.class, () -> GameStarter.main(new String[] {}));

        String output = outputStream.toString();
        assertTrue(
            output.contains("Welcome to Hangman!"),
            "Game should start correctly on attempt " + (1 + 1)
        );
    }
    {
        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));
        outputStream.reset();

        assertThrows(SecurityException.class, () -> GameStarter.main(new String[] {}));

        String output = outputStream.toString();
        assertTrue(
            output.contains("Welcome to Hangman!"),
            "Game should start correctly on attempt " + (2 + 1)
        );
    }
}

@Test
    void testGameStarterMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        System.setIn(new ByteArrayInputStream(EXIT_COMMAND.getBytes()));
        assertThrows(SecurityException.class, () -> GameStarter.main(new String[]{}));

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        assertTrue((usedMemoryAfter - usedMemoryBefore) < 1000000,
            "Game should not consume excessive memory");
    }

}
