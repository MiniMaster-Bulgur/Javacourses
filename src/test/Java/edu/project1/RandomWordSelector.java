package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import proect.proect1.RandomWordSelector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class RandomWordSelectorTest {
    private RandomWordSelector wordSelector;
    private static final String TEST_FILE_PATH = "C:\\Javacourses\\src\\main\\java\\proect\\proect1\\resourses\\wordsgame.txt";

    @BeforeEach
    void setUp() {
        wordSelector = new RandomWordSelector();
    }

    @Test
    void testFileExists() {
        File file = new File(TEST_FILE_PATH);
        assertTrue(file.exists(), "Word file should exist");
        assertTrue(file.canRead(), "Word file should be readable");
    }

    @Test
    void testLoadWordsFromFile() {
        assertDoesNotThrow(() -> {
            RandomWordSelector selector = new RandomWordSelector();
            String word = selector.getRandomLySelectedWord();
            assertNotNull(word, "Should return a non-null word");
            assertFalse(word.isEmpty(), "Should return a non-empty word");
        });
    }

    @Test
    void testRandomWordSelection() {
        Set<String> uniqueWords = new HashSet<>();
        int attempts = 50;

        for (int i = 0; i < attempts; i++) {
            String word = wordSelector.getRandomLySelectedWord();
            uniqueWords.add(word);
        }

        assertTrue(uniqueWords.size() > 1,
            "Multiple calls should return different words (randomness check)");
    }

    @Test
    void testWordFormat() {
        String word = wordSelector.getRandomLySelectedWord();
        assertTrue(word.matches("[a-z]+"),
            "Word should contain only lowercase letters");
    }

    @Test
    void testWithCustomWordFile(@TempDir Path tempDir) throws IOException {
        // Создаем временный тестовый файл
        File testFile = tempDir.resolve("test_words.txt").toFile();
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("test\nword\nexample\n");
        }

// Проверяем содержимое файла
        try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                assertFalse(line.isEmpty(), "File should not contain empty lines");
                assertTrue(line.matches("[a-zA-Z]+"),
                    "Words should contain only letters");
            }
        }
    }

    @Test
    void testWordLowerCase() {
        String word = wordSelector.getRandomLySelectedWord();
        assertEquals(word.toLowerCase(), word,
            "Word should be in lowercase");
    }

    @Test
    void testMultipleInstancesConsistency() {
        RandomWordSelector selector1 = new RandomWordSelector();
        RandomWordSelector selector2 = new RandomWordSelector();

        assertNotNull(selector1.getRandomLySelectedWord());
        assertNotNull(selector2.getRandomLySelectedWord());
    }

    @Test
    void testPerformance() {
        long startTime = System.currentTimeMillis();
        int iterations = 1000;

        for (int i = 0; i < iterations; i++) {
            assertNotNull(wordSelector.getRandomLySelectedWord());
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        assertTrue(duration < 1000,
            "Word selection should be performed quickly");
    }

    @Test
    void testMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        RandomWordSelector newSelector = new RandomWordSelector();
        for (int i = 0; i < 1000; i++) {
            newSelector.getRandomLySelectedWord();
        }

        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryDiff = usedMemoryAfter - usedMemoryBefore;

        assertTrue(memoryDiff < 10_000_000,
            "Memory usage should be reasonable");
    }

    @Test
    void testConcurrentAccess() throws InterruptedException {
        int threadCount = 10;
        Thread[] threads = new Thread[threadCount];
        Set<String> concurrentWords = new HashSet<>();

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                String word = wordSelector.getRandomLySelectedWord();
                synchronized (concurrentWords) {
                    concurrentWords.add(word);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        assertFalse(concurrentWords.isEmpty());
    }
}
