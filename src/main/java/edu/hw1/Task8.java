package edu.hw1;

/**
 * Task8: Verifies that no knights on a chessboard can attack each other.
 */
public class Task8 {

    /**
     * Checks if knights on a chessboard can capture each other.
     * Each knight is represented by a '1' on an 8x8 board.
     *
     * @param board a two-dimensional array representing the chessboard
     * @return true if no knights can capture each other; otherwise false
     * @throws IllegalArgumentException if the board is not 8x8
     */
    public boolean knightBoardCapture(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        if (rows != 8 || cols != 8) {
            throw new IllegalArgumentException("The board must be 8x8.");
        }

        // Possible knight moves
        int[][] moves = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        // Iterate through each position on the board
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 1) { // If a knight is present
                    for (int[] move : moves) {
                        int newR = r + move[0];
                        int newC = c + move[1];

                        // Check if the new position is within bounds and has another knight
                        if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && board[newR][newC] == 1) {
                            return false; // Knights can capture each other
                        }
                    }
                }
            }
        }

        return true; // No knights can capture each other
    }

    /**
     * Main method to test the knightBoardCapture method.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task8 solution = new Task8();

        int[][] board1 = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        System.out.println(solution.knightBoardCapture(board1)); // true

        int[][] board2 = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        System.out.println(solution.knightBoardCapture(board2)); // false
    }
}
