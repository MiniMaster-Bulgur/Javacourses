package proect.proect1;

import java.util.Arrays;
import java.util.logging.Logger;

public class HangmanDrawer {

    private static final Logger LOGGER = Logger.getLogger(HangmanDrawer.class.getName());
    private static final int MATRIX_SIZE = 8;

    private static final int ROW_1 = 0;
    private static final int ROW_2 = 1;
    private static final int ROW_3 = 2;
    private static final int ROW_4 = 3;
    private static final int ROW_5 = 4;
    private static final int ROW_6 = 5;
    private static final int ROW_7 = 6;

    private static final int COL_0 = 0;
    private static final int COL_1 = 1;
    private static final int COL_2 = 2;
    private static final int COL_3 = 3;
    private static final int COL_4 = 4;
    private static final int COL_5 = 5;
    private static final int COL_7 = 7;
    private static final int ROW_0 = 0;

    private final String[][] hangmanDrawingMatrix = new String[MATRIX_SIZE][MATRIX_SIZE];

    public HangmanDrawer() {
        clearDrawing();
    }

    public void printHangman() {
        StringBuilder hangmanDrawing = new StringBuilder();
        for (String[] drawingMatrixRow : hangmanDrawingMatrix) {
            for (int i = 0; i < drawingMatrixRow.length; i++) {
                hangmanDrawing.append(drawingMatrixRow[i]);
                if (i == drawingMatrixRow.length - 1) {
                    hangmanDrawing.append("\n");
                }
            }
        }
        LOGGER.info(hangmanDrawing.toString());
    }

    public void updateHangmanDrawingMatrix(int numbarOfMistakes) {
        switch (numbarOfMistakes) {
            case 1 -> {
                hangmanDrawingMatrix[ROW_7][COL_0] = "/";
                hangmanDrawingMatrix[ROW_7][COL_1] = "-";
                hangmanDrawingMatrix[ROW_7][COL_2] = "\\";
                hangmanDrawingMatrix[ROW_6][COL_2] = "|";
                hangmanDrawingMatrix[ROW_5][COL_2] = "|";
                hangmanDrawingMatrix[ROW_4][COL_2] = "|";
                hangmanDrawingMatrix[ROW_3][COL_2] = "|";
            }
            case 2 -> {
                hangmanDrawingMatrix[ROW_2][COL_1] = "|";
                hangmanDrawingMatrix[ROW_1][COL_1] = "|";
                hangmanDrawingMatrix[ROW_0][COL_2] = "_";
            }
            case 3 -> {
                hangmanDrawingMatrix[ROW_0][COL_3] = "_";
                hangmanDrawingMatrix[ROW_0][COL_5] = "_";
                hangmanDrawingMatrix[ROW_0][COL_4] = "_";
                hangmanDrawingMatrix[ROW_1][COL_7] = "|";
            }
            case 4 -> {
                hangmanDrawingMatrix[ROW_2][COL_4] = "(";
                hangmanDrawingMatrix[ROW_2][COL_5] = ")";
                hangmanDrawingMatrix[ROW_3][COL_4] = "/";
                hangmanDrawingMatrix[ROW_3][COL_5] = "\\";
            }
            case 5 -> {
                hangmanDrawingMatrix[ROW_4][COL_5] = "|";
                hangmanDrawingMatrix[ROW_5][COL_4] = "/";
                hangmanDrawingMatrix[ROW_5][COL_5] = "\\";
            }
            default -> LOGGER.warning("Unexpected number of mistakes: " + numbarOfMistakes);
        }
    }

    public void clearDrawing() {
        for (String[] drawingMatrixRow : hangmanDrawingMatrix) {
            Arrays.fill(drawingMatrixRow, "");
        }
    }
}
