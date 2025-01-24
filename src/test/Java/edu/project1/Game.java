package edu.project1;

import org.junit.jupiter.api.*;
import proect.proect1.Game;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
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
        game = new Game();
        System.setOut(new PrintStream(outContent));
        testLogHandler.clear();
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testGameStart() {
        String input = "E\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("Добро пожаловать в Виселицу!"));
        assertTrue(log.contains("Меню: [N]овая игра / [E]выход"));
    }

    @Test
    void testInvalidMenuOption() {
        String input = "X\nE\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("Неверный выбор. Пожалуйста, попробуйте снова."));
    }

    @Test
    void testNewGame() {
        String input = "N\na\nE\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("Новая игра начата"));
        assertTrue(log.contains("Длина слова:"));
        assertTrue(log.contains("Угаданные буквы: "));
        assertTrue(log.contains("Неугаданные буквы: "));
    }

    @Test
    void testCorrectGuess() {
        // Предполагаем, что в слове есть буква 'а'
        String input = "N\na\nE\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("Правильно!"));
        assertTrue(log.contains("Угаданные буквы: "));
    }

    @Test
    void testIncorrectGuess() {
        String input = "N\nq\nE\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("Неверно!"));
        assertTrue(log.contains("Неугаданные буквы: "));
    }

    @Test
    void testSpaceInput() {
        String input = "N\n \nE\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("Пожалуйста, пишите без пробелов!"));
    }

    @Test
    void testRepeatedLetter() {
        String input = "N\na\na\nE\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("Вы уже пробовали эту букву!"));
    }

    @Test
    void testGameStatistics() {
        String input = "N\na\nb\nc\nE\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("Угаданные буквы:"));
        assertTrue(log.contains("Неугаданные буквы:"));
        assertTrue(log.contains("Ошибки:"));
    }

    @Test
    void testGameOver() {
        String input = "N\n" + "q\n".repeat(6) + "E\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(SecurityException.class, () -> game.start());

        String log = testLogHandler.getLog();
        assertTrue(log.contains("=== ИГРА ОКОНЧЕНА ==="));
        assertTrue(log.contains("Всего угадано букв:"));
        assertTrue(log.contains("Всего ошибок:"));
    }
}
