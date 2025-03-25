package proect.proect1;

import java.util.Arrays;
import java.util.logging.Logger;

public class HangmanDrawer {

    private static final Logger LOGGER = Logger.getLogger(HangmanDrawer.class.getName());
    private static final int MATRIX_SIZE = 8;

    // Константы для строк
    private static final int ROW_BASE = 7;
    private static final int ROW_HEAD = 0;
    private static final int ROW_BODY = 4;
    private static final int ROW_LEFT_ARM = 2;
    private static final int ROW_RIGHT_ARM = 2;
    private static final int ROW_LEFT_LEG = 5;
    private static final int ROW_RIGHT_LEG = 5;

    // Константы для столбцов
    private static final int COL_POST = 2;
    private static final int COL_HEAD = 4;
    private static final int COL_BODY = 4;
    private static final int COL_LEFT_ARM = 3;
    private static final int COL_RIGHT_ARM = 5;
    private static final int COL_LEFT_LEG = 4;
    private static final int COL_RIGHT_LEG = 5;

    // Константа для сообщения об ошибке
    private static final String UNEXPECTED_MISTAKES_MESSAGE = "Unexpected number of mistakes: %d";

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
                hangmanDrawingMatrix[ROW_BASE][COL_POST - 2] = "/";
                hangmanDrawingMatrix[ROW_BASE][COL_POST - 1] = "-";
                hangmanDrawingMatrix[ROW_BASE][COL_POST] = "\\";
                hangmanDrawingMatrix[ROW_BASE - 1][COL_POST] = "|";
                hangmanDrawingMatrix[ROW_BASE - 2][COL_POST] = "|";
                hangmanDrawingMatrix[ROW_BASE - 3][COL_POST] = "|";
                hangmanDrawingMatrix[ROW_BASE - 4][COL_POST] = "|";
            }
            case 2 -> {
                hangmanDrawingMatrix[ROW_LEFT_ARM][COL_POST - 1] = "|";
                hangmanDrawingMatrix[ROW_LEFT_ARM - 1][COL_POST - 1] = "|";
                hangmanDrawingMatrix[ROW_HEAD][COL_POST] = "_";
            }
            case 3 -> {
                hangmanDrawingMatrix[ROW_HEAD][COL_HEAD - 1] = "_";
                hangmanDrawingMatrix[ROW_HEAD][COL_HEAD + 1] = "_";
                hangmanDrawingMatrix[ROW_HEAD][COL_HEAD] = "_";
                hangmanDrawingMatrix[ROW_LEFT_ARM - 1][COL_POST + 5] = "|";
            }
            case 4 -> {
                hangmanDrawingMatrix[ROW_LEFT_ARM][COL_LEFT_ARM] = "(";
                hangmanDrawingMatrix[ROW_LEFT_ARM][COL_RIGHT_ARM] = ")";
                hangmanDrawingMatrix[ROW_RIGHT_ARM][COL_LEFT_ARM] = "/";
                hangmanDrawingMatrix[ROW_RIGHT_ARM][COL_RIGHT_ARM] = "\\";
            }
            case 5 -> {
                hangmanDrawingMatrix[ROW_BODY][COL_BODY] = "|";
                hangmanDrawingMatrix[ROW_LEFT_LEG][COL_LEFT_LEG] = "/";
                hangmanDrawingMatrix[ROW_RIGHT_LEG][COL_RIGHT_LEG] = "\\";
            }
            default -> LOGGER.warning(String.format(UNEXPECTED_MISTAKES_MESSAGE, numbarOfMistakes));
        }
    }

    public void clearDrawing() {
        for (String[] drawingMatrixRow : hangmanDrawingMatrix) {
            Arrays.fill(drawingMatrixRow, "");
        }
    }
}
