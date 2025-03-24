package edu.hw1;

public final class Task8 {

    private static final int BOARD_SIZE = 8;

    public boolean knightBoardCapture(final int[][] board) {
        final int rows = board.length;
        final int cols = board[0].length;

        if (rows != BOARD_SIZE || cols != BOARD_SIZE) {
            throw new IllegalArgumentException("Ошибка: доска должна быть размером 8x8.");
        }

        final int[][] moves = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 1) {
                    for (int[] move : moves) {
                        int newR = r + move[0];
                        int newC = c + move[1];

                        if (newR >= 0
                            && newR < rows
                            && newC >= 0
                            && newC < cols
                            && board[newR][newC] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
