package edu.hw1;

import edu.hw1.Task8;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    Task8 task8 = new Task8();

    @Test
    void testNoKnights() {
        int[][] board = new int[8][8]; // Пустая доска
        assertTrue(task8.knightBoardCapture(board));
    }

    @Test
    void testSingleKnight() {
        int[][] board = new int[8][8];
        board[0][0] = 1; // Один конь
        assertTrue(task8.knightBoardCapture(board));
    }

    @Test
    void testKnightsCanCaptureEachOther() {
        int[][] board = new int[8][8];
        board[0][0] = 1; // Первый конь
        board[2][1] = 1; // Второй конь, который может захватить первого
        assertFalse(task8.knightBoardCapture(board));
    }

    @Test
    void testKnightsCannotCaptureEachOther() {
        int[][] board = new int[8][8];
        board[0][0] = 1;
        board[3][3] = 1; // Два коня, которые не могут захватить друг друга
        assertTrue(task8.knightBoardCapture(board));
    }

    @Test
    void testInvalidBoardSize() {
        int[][] board = new int[5][5]; // Неправильный размер доски
        assertThrows(IllegalArgumentException.class, () -> task8.knightBoardCapture(board));
    }
}
