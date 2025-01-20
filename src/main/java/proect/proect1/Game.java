package proect.proect1;

import java.util.Scanner;

public class Game {
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMaskOperator maskOperator = new WordMaskOperator();
    private static final int MAX_MISTAKES = 6;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");

        while (true) {
            System.out.println("\nMenu: [N]ew game / [E]xit");
            String option = scanner.nextLine().trim().toUpperCase();

            switch (option) {
                case "N":
                    playGame(scanner);
                    break;
                case "E":
                    System.out.println("Thanks for playing! Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void playGame(Scanner scanner) {
        int mistakesCount = 0;
        maskOperator.clearBuffer();
        hangmanDrawer.clearDrawing();

        String guessedWord = wordSelector.getRandomLySelectedWord();
        maskOperator.setWord(guessedWord);

        System.out.println("\n=== New Game Started ===");
        System.out.printf("Word length: %d letters\n", guessedWord.length());
        System.out.print("Word: ");
        maskOperator.printMask();

        while (!maskOperator.userWon() && mistakesCount < MAX_MISTAKES) {
            System.out.println("\nUsed letters: " + maskOperator.getUsedLettersAsString());
            System.out.printf("Mistakes: %d/%d\n", mistakesCount, MAX_MISTAKES);
            hangmanDrawer.printHangman();

            System.out.print("\nEnter a letter: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter!");
                continue;
            }

            if (maskOperator.isLetterAlreadyUsed(input)) {
                System.out.println("You already tried this letter!");
                continue;
            }

            maskOperator.useUserInputLetter(input);

            if (maskOperator.containsLetter(input)) {
                maskOperator.updateMask(input);
                System.out.println("Correct!");
                System.out.print("Word: ");
                maskOperator.printMask();
            } else {
                mistakesCount++;
                System.out.println("Wrong!");
                hangmanDrawer.updateHangmanDrawingMatrix(mistakesCount);
            }
        }

        System.out.println("\n=== Game Over ===");
        if (maskOperator.userWon()) {
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("You lost! The word was: " + guessedWord);
        }
        System.out.println("=================\n");
    }
}
