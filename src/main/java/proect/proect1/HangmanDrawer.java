package proect.proect1;

import java.util.Arrays;
import java.util.logging.Logger;

public class HangmanDrawer {

    private static final Logger LOGGER = Logger.getLogger(HangmanDrawer.class.getName());

    private static final int MATRIX_SIZE = 8;

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
                hangmanDrawingMatrix[7][0] = "/";
                hangmanDrawingMatrix[7][1] = "-";
                hangmanDrawingMatrix[7][2] = "\\";
                hangmanDrawingMatrix[6][2] = "|";
                hangmanDrawingMatrix[5][2] = "|";
                hangmanDrawingMatrix[4][2] = "|";
                hangmanDrawingMatrix[3][2] = "|";
            }
            case 2 -> {
                hangmanDrawingMatrix[2][1] = "|";
                hangmanDrawingMatrix[1][1] = "|";
                hangmanDrawingMatrix[0][2] = "_";
            }
            case 3 -> {
                hangmanDrawingMatrix[0][3] = "_";
                hangmanDrawingMatrix[0][5] = "_";
                hangmanDrawingMatrix[0][4] = "_";
                hangmanDrawingMatrix[1][7] = "|";
            }
            case 4 -> {
                hangmanDrawingMatrix[2][4] = "(";
                hangmanDrawingMatrix[2][5] = ")";
                hangmanDrawingMatrix[3][4] = "/";
                hangmanDrawingMatrix[3][5] = "\\";
            }
            case 5 -> {
                hangmanDrawingMatrix[4][5] = "|";
                hangmanDrawingMatrix[5][4] = "/";
                hangmanDrawingMatrix[5][5] = "\\";
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
