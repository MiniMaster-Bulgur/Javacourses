package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proect.proect1.HangmanDrawer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class HangmanDrawerTest {
    private HangmanDrawer drawer;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        drawer = new HangmanDrawer();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testInitialState() {
        drawer.printHangman();
        String output = outputStream.toString();
        assertTrue(output.trim().isEmpty(), "Initial state should be empty");
    }

    @Test
    void testClearDrawing() {
        drawer.updateHangmanDrawingMatrix(1);
        drawer.clearDrawing();
        outputStream.reset();
        drawer.printHangman();
        String output = outputStream.toString();
        assertTrue(output.trim().isEmpty(), "After clearing, drawing should be empty");
    }

    @Test
    void testFirstMistake() {
        drawer.updateHangmanDrawingMatrix(1);
        outputStream.reset();
        drawer.printHangman();
        String output = outputStream.toString();
        assertTrue(output.contains("/"));
        assertTrue(output.contains("-"));
        assertTrue(output.contains("\\"));
        assertTrue(output.contains("|"));
    }

    @Test
    void testSecondMistake() {
        drawer.updateHangmanDrawingMatrix(2);
        outputStream.reset();
        drawer.printHangman();
        String output = outputStream.toString();
        assertTrue(output.contains("|"));
        assertTrue(output.contains("_"));
    }

    @Test
    void testThirdMistake() {
        drawer.updateHangmanDrawingMatrix(3);
        outputStream.reset();
        drawer.printHangman();
        String output = outputStream.toString();
        assertTrue(output.contains("_"));
        assertTrue(output.contains("|"));
    }

    @Test
    void testFourthMistake() {
        drawer.updateHangmanDrawingMatrix(4);
        outputStream.reset();
        drawer.printHangman();
        String output = outputStream.toString();
        assertTrue(output.contains("("));
        assertTrue(output.contains(")"));
        assertTrue(output.contains("/"));
        assertTrue(output.contains("\\"));
    }

    @Test
    void testFifthMistake() {
        drawer.updateHangmanDrawingMatrix(5);
        outputStream.reset();
        drawer.printHangman();
        String output = outputStream.toString();
        assertTrue(output.contains("|"));
        assertTrue(output.contains("/"));
        assertTrue(output.contains("\\"));
    }

    @Test
    void testProgressiveDrawing() {
        String previousOutput = "";
        for (int i = 1; i <= 5; i++) {
            outputStream.reset();
            drawer.updateHangmanDrawingMatrix(i);
            drawer.printHangman();
            String currentOutput = outputStream.toString();
            assertNotEquals(previousOutput, currentOutput,
                "Drawing should change with each mistake");
            previousOutput = currentOutput;
        }
    }

    @Test
    void testMatrixSize() {
        drawer.updateHangmanDrawingMatrix(5);
        outputStream.reset();
        drawer.printHangman();
        String output = outputStream.toString();
        String[] lines = output.split("\n");
        assertTrue(lines.length <= 8, "Matrix should not exceed 8 rows");
        for (String line : lines) {
            assertTrue(line.length() <= 8, "Matrix should not exceed 8 columns");
        }
    }

    @Test
    void testInvalidMistakeNumber() {
        drawer.updateHangmanDrawingMatrix(10);
        outputStream.reset();
        drawer.printHangman();
        // Проверяем, что некорректное число ошибок не вызывает исключений
        assertDoesNotThrow(() -> drawer.updateHangmanDrawingMatrix(10));
    }

}
