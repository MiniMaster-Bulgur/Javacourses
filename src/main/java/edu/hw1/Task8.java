package edu.hw1;

public class Task8 {

    public boolean knightBoardCapture(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        if (rows != 8 || cols != 8) {
            throw new IllegalArgumentException();
        }

        int[][] moves = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
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
