package proect.proect1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class RandomWordSelector {
    private static final Logger LOGGER = Logger.getLogger(RandomWordSelector.class.getName());

    private final List<String> words = new ArrayList<>();
    private final Random random = new Random();
    private static final String WORDS_FILE =
        "C:\\Javacourses\\src\\main\\java\\proect\\proect1\\resourses\\wordsgame.txt";

    public RandomWordSelector() {
        loadWordsFromFile();
    }

    private void loadWordsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(WORDS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    words.add(trimmedLine.toLowerCase());
                }
            }
            if (words.isEmpty()) {
                throw new IOException("No words found in file: " + WORDS_FILE);
            }
            LOGGER.info("Successfully loaded " + words.size() + " words from file");
        } catch (IOException e) {
            LOGGER.severe("Error: Cannot read words from file: " + WORDS_FILE);
            LOGGER.severe("Error details: " + e.getMessage());
            LOGGER.severe("Please ensure the file exists and is accessible");
            System.exit(1);
        }
    }

    public String getRandomLySelectedWord() {
        if (words.isEmpty()) {
            LOGGER.severe("Fatal error: No words available");
            System.exit(1);
        }
        return words.get(random.nextInt(words.size()));
    }
}
