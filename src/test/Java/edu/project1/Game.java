package edu.project1;

import org.junit.jupiter.api.*;
import proect.proect1.Game;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = out;
    private static TestLogHandler testLogHandler;

    static class TestLogHandler extends Handler {
        private StringBuilder log = new StringBuilder();

        @Override
        public void publish(LogRecord record) {
            log.append(record.getMessage()).append("\n");
        }

        @Override
        public void flush() {
            log = new StringBuilder();
        }

        @Override
        public void close() throws SecurityException {
            flush();
        }

        public String getLog() {
            return log.toString();
        }

        public void clear() {
            flush();
        }
    }

    @BeforeAll
    static void setUpLogger() {
        Logger logger = Logger.getLogger(Game.class.getName());
        testLogHandler = new TestLogHandler();
        logger.addHandler(testLogHandler);
    }

    @BeforeEach
    void setUp() {
        Game game = new Game();
        setOut(new PrintStream(outContent));
        testLogHandler.clear();
    }

    @AfterEach
    void restoreStreams() {
        setOut(originalOut);
    }

    // Тесты для класса GameResult
    @Nested
    class GameResultTest {

        @Test
        public void testGameResultConstructorAndGetters() {
            int expectedMistakes = 3;
            int expectedCorrectGuesses = 5;
            int expectedIncorrectGuesses = 2;

            Game.GameResult result = new Game.GameResult(expectedMistakes, expectedCorrectGuesses, expectedIncorrectGuesses);

            assertEquals(expectedMistakes, result.getMistakesCount(), "Количество ошибок не совпадает");
            assertEquals(expectedCorrectGuesses, result.getCorrectGuesses(), "Количество верных предположений не совпадает");
            assertEquals(expectedIncorrectGuesses, result.getIncorrectGuesses(), "Количество неверных предположений не совпадает");
        }
    }
}
