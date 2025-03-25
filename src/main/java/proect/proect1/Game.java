package proect.proect1;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class Game {

    public static final int MAX_MISTAKES = 6;
    private static final Logger LOGGER = Logger.getLogger(Game.class.getName());
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMaskOperator maskOperator = new WordMaskOperator();

    private static final String WORD_LABEL = "Слово:";
    private static final String TOTAL_GUESSED_LETTERS = "Всего угадано букв: %d";
    private static final String TOTAL_ERRORS = "Всего ошибок: %d";
    private static final String SEPARATOR = "================";

    public Game() {
        LOGGER.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public String format(java.util.logging.LogRecord logRecord) {
                return logRecord.getMessage() + "\n";
            }
        });
        LOGGER.addHandler(handler);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Добро пожаловать в Виселицу!");

        while (true) {
            LOGGER.info("\nМеню: [N]овая игра / [E]выход");
            String option = scanner.nextLine().trim().toUpperCase();

            switch (option) {
                case "N":
                    playGame(scanner);
                    break;
                case "E":
                    LOGGER.info("Спасибо за игру! До свидания!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    LOGGER.warning("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    public Result playGame(Scanner scanner) {
        int mistakesCount = 0;
        int correctGuesses = 0;
        int incorrectGuesses = 0;

        maskOperator.clearBuffer();
        hangmanDrawer.clearDrawing();

        String guessedWord = wordSelector.getRandomLySelectedWord();
        maskOperator.setWord(guessedWord);

        LOGGER.info("\n=== Новая игра начата ===");
        LOGGER.info(String.format("Длина слова: %d букв", guessedWord.length()));
        LOGGER.info(WORD_LABEL);
        maskOperator.printMask();

        while (true) {
            LOGGER.info("\nИспользованные буквы: " + maskOperator.getUsedLettersAsString());
            LOGGER.info(String.format("Ошибки: %d/%d", mistakesCount, MAX_MISTAKES));
            LOGGER.info(String.format("Угаданные буквы: %d", correctGuesses));
            LOGGER.info(String.format("Неугаданные буквы: %d", incorrectGuesses));
            hangmanDrawer.printHangman();

            LOGGER.info("\nВведите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.contains(" ")) {
                LOGGER.warning("Пожалуйста, пишите без пробелов!");
                continue;
            }

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                LOGGER.warning("Пожалуйста, введите одну букву!");
                continue;
            }

            if (maskOperator.isLetterAlreadyUsed(input)) {
                LOGGER.warning("Вы уже пробовали эту букву!");
                continue;
            }

            maskOperator.useUserInputLetter(input);

            if (maskOperator.containsLetter(input)) {
                correctGuesses++;
                maskOperator.updateMask(input);
                LOGGER.info("Правильно!");
                LOGGER.info(WORD_LABEL);
                maskOperator.printMask();

                if (maskOperator.userWon()) {
                    LOGGER.info("\n=== ПОБЕДА! ===");
                    LOGGER.info("Поздравляем! Вы выиграли!");
                    LOGGER.info("Загаданное слово было: " + guessedWord);
                    LOGGER.info(String.format(TOTAL_GUESSED_LETTERS, correctGuesses));
                    LOGGER.info(String.format(TOTAL_ERRORS, incorrectGuesses));
                    LOGGER.info(SEPARATOR);
                    break; // Завершаем цикл при победе
                }
            } else {
                incorrectGuesses++;
                mistakesCount++;
                LOGGER.warning("Неверно!");
                hangmanDrawer.updateHangmanDrawingMatrix(mistakesCount);

                if (mistakesCount >= MAX_MISTAKES) {
                    LOGGER.info("\n=== ИГРА ОКОНЧЕНА ===");
                    LOGGER.info("Вы проиграли! Загаданное слово было: " + guessedWord);
                    LOGGER.info(String.format(TOTAL_GUESSED_LETTERS, correctGuesses));
                    LOGGER.info(String.format(TOTAL_ERRORS, incorrectGuesses));
                    LOGGER.info(SEPARATOR);
                    break; // Завершаем цикл при поражении
                }
            }
        }

        return new Result(mistakesCount, correctGuesses); // Возвращаем результат игры
    }

    // Внутренний класс для хранения результатов игры
    public static class Result {
        private final int mistakesCount;
        private final int correctGuesses;

        public Result(int mistakesCount, int correctGuesses) {
            this.mistakesCount = mistakesCount;
            this.correctGuesses = correctGuesses;
        }

        public int getMistakesCount() {
            return mistakesCount;
        }

        public int getCorrectGuesses() {
            return correctGuesses;
        }
    }
}
