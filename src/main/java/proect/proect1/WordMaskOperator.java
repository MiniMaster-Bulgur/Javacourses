package proect.proect1;

import java.util.Arrays;

public class WordMaskOperator {
    private String word;
    private char[] mask;
    private final StringBuilder usedLetters;
    private int correctGuesses;

    public WordMaskOperator() {
        usedLetters = new StringBuilder();
        correctGuesses = 0;
    }

    public void setWord(String word) {
        this.word = word.toLowerCase();
        this.mask = new char[word.length()];
        Arrays.fill(mask, '_');
        usedLetters.setLength(0);
        correctGuesses = 0;
    }

    public void printMask() {
        for (char c : mask) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void updateMask(String letter) {
        char c = letter.toLowerCase().charAt(0);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c && mask[i] == '_') {
                mask[i] = c;
                correctGuesses++;
            }
        }
    }

    public boolean containsLetter(String letter) {
        return word.contains(letter.toLowerCase());
    }

    public void useUserInputLetter(String letter) {
        char c = letter.toLowerCase().charAt(0);
        if (usedLetters.indexOf(String.valueOf(c)) == -1) {
            if (!usedLetters.isEmpty()) {
                usedLetters.append(", ");
            }
            usedLetters.append(c);
        }
    }

    public boolean isLetterAlreadyUsed(String letter) {
        return usedLetters.indexOf(letter.toLowerCase()) != -1;
    }

    public boolean userWon() {
        return correctGuesses == getUniqueLettersCount();
    }

    private int getUniqueLettersCount() {
        return (int) word.chars().distinct().count();
    }

    public void clearBuffer() {
        usedLetters.setLength(0);
        correctGuesses = 0;
        if (mask != null) {
            Arrays.fill(mask, '_');
        }
    }

    public String getUsedLettersAsString() {
        return usedLetters.toString();
    }

    public int getCorrectGuessCount() {
        return correctGuesses;
    }
}
