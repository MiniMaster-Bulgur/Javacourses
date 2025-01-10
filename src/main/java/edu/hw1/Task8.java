package edu.hw1;

public class Task8 {

    private Task8() {
    }

    private static final int RER = 8;
    private static final int RAR = -2;

    public static boolean knightBoardCapture(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        if (rows != RER || cols != RER) {
            throw new IllegalArgumentException("The board must be 8x8.");
        }

        int[][] moves = {
            {RAR, -1}, {RAR, 1}, {-1, RAR}, {-1, 2},
            {1, RAR}, {1, 2}, {2, -1}, {2, 1}
        };

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 1) {
                    for (int[] move : moves) {
                        int newR = r + move[0];
                        int newC = c + move[1];

                        if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && board[newR][newC] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
