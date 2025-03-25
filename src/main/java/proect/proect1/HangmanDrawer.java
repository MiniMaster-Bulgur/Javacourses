package proect.proect1;

import java.util.Arrays;
import java.util.logging.Logger;

public class HangmanDrawer {

    private static final Logger LOGGER = Logger.getLogger(HangmanDrawer.class.getName());
    private static final int MATRIX_SIZE = 8;

    private static final int ROW_1 = 1;
    private static final int ROW_2 = 2;
    private static final int ROW_3 = 3;
    private static final int ROW_4 = 4;
    private static final int ROW_5 = 5;
    private static final int ROW_6 = 6;

    private static final int COL_0 = 0;
    private static final int COL_1 = 1;
    private static final int COL_2 = 2;
    private static final int COL_3 = 3;
    private static final int COL_5 = 5;
    private static final int COL_7 = 7;

    // Конфигурационные константы для рисования виселицы
    private static final int BASE_ROW = 7;
    private static final int POST_COL = 2;
    private static final int TOP_ROW = 0;
    private static final int HEAD_COL = 4;
    private static final int BODY_COL = 4;
    private static final int LEFT_ARM_COL = 3;
    private static final int RIGHT_ARM_COL = 5;
    private static final int LEFT_LEG_COL = 4;
    private static final int RIGHT_LEG_COL = 5;
    private static final ThreadLocal<String> UNEXPECTED_MISTAKES_MESSAGE = new ThreadLocal<>();

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
                hangmanDrawingMatrix[BASE_ROW][COL_0] = "/";
                hangmanDrawingMatrix[BASE_ROW][COL_1] = "-";
                hangmanDrawingMatrix[BASE_ROW][COL_2] = "\\";
                hangmanDrawingMatrix[ROW_6][POST_COL] = "|";
                hangmanDrawingMatrix[ROW_5][POST_COL] = "|";
                hangmanDrawingMatrix[ROW_4][POST_COL] = "|";
                hangmanDrawingMatrix[ROW_3][POST_COL] = "|";
            }
            case 2 -> {
                hangmanDrawingMatrix[ROW_2][COL_1] = "|";
                hangmanDrawingMatrix[ROW_1][COL_1] = "|";
                hangmanDrawingMatrix[TOP_ROW][COL_2] = "_";
            }
            case 3 -> {
                hangmanDrawingMatrix[TOP_ROW][COL_3] = "_";
                hangmanDrawingMatrix[TOP_ROW][COL_5] = "_";
                hangmanDrawingMatrix[TOP_ROW][HEAD_COL] = "_";
                hangmanDrawingMatrix[ROW_1][COL_7] = "|";
            }
            case 4 -> {
                hangmanDrawingMatrix[ROW_2][LEFT_ARM_COL] = "(";
                hangmanDrawingMatrix[ROW_2][RIGHT_ARM_COL] = ")";
                hangmanDrawingMatrix[ROW_3][LEFT_ARM_COL] = "/";
                hangmanDrawingMatrix[ROW_3][RIGHT_ARM_COL] = "\\";
            }
            case 5 -> {
                hangmanDrawingMatrix[ROW_4][BODY_COL] = "|";
                hangmanDrawingMatrix[ROW_5][LEFT_LEG_COL] = "/";
                hangmanDrawingMatrix[ROW_5][RIGHT_LEG_COL] = "\\";
            }
            default -> LOGGER.warning(String.format(UNEXPECTED_MISTAKES_MESSAGE.get(), numbarOfMistakes));
        }
    }

    public void clearDrawing() {
        for (String[] drawingMatrixRow : hangmanDrawingMatrix) {
            Arrays.fill(drawingMatrixRow, "");
        }
    }
}
