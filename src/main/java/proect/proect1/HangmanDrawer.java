package proect.proect1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

public class HangmanDrawer {

    private static final Logger LOGGER = Logger.getLogger(HangmanDrawer.class.getName());
    private static final int MATRIX_SIZE = 8;

    private static int BASE_ROW;
    private static int POST_COL;
    private static int TOP_ROW;
    private static int HEAD_COL;
    private static int BODY_COL;
    private static int LEFT_ARM_COL;
    private static int RIGHT_ARM_COL;
    private static int LEFT_LEG_COL;
    private static int RIGHT_LEG_COL;

    private static final String UNEXPECTED_MISTAKES_MESSAGE = "Unexpected number of mistakes: %d";

    private final String[][] hangmanDrawingMatrix;

    public HangmanDrawer() {
        hangmanDrawingMatrix = new String[MATRIX_SIZE][MATRIX_SIZE];
        loadConfig();
        clearDrawing();
    }

    private void loadConfig() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                LOGGER.severe("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
            BASE_ROW = Integer.parseInt(properties.getProperty("BASE_ROW"));
            POST_COL = Integer.parseInt(properties.getProperty("POST_COL"));
            TOP_ROW = Integer.parseInt(properties.getProperty("TOP_ROW"));
            HEAD_COL = Integer.parseInt(properties.getProperty("HEAD_COL"));
            BODY_COL = Integer.parseInt(properties.getProperty("BODY_COL"));
            LEFT_ARM_COL = Integer.parseInt(properties.getProperty("LEFT_ARM_COL"));
            RIGHT_ARM_COL = Integer.parseInt(properties.getProperty("RIGHT_ARM_COL"));
            LEFT_LEG_COL = Integer.parseInt(properties.getProperty("LEFT_LEG_COL"));
            RIGHT_LEG_COL = Integer.parseInt(properties.getProperty("RIGHT_LEG_COL"));
        } catch (IOException ex) {
            LOGGER.severe("Error loading config file: " + ex.getMessage());
        }
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

    public void updateHangmanDrawingMatrix(int numberOfMistakes) {
        switch (numberOfMistakes) {
            case 1 -> {
                hangmanDrawingMatrix[BASE_ROW][POST_COL - 2] = "/";
                hangmanDrawingMatrix[BASE_ROW][POST_COL - 1] = "-";
                hangmanDrawingMatrix[BASE_ROW][POST_COL] = "\\";
                hangmanDrawingMatrix[BASE_ROW - 1][POST_COL] = "|";
                hangmanDrawingMatrix[BASE_ROW - 2][POST_COL] = "|";
                hangmanDrawingMatrix[BASE_ROW - 3][POST_COL] = "|";
                hangmanDrawingMatrix[BASE_ROW - 4][POST_COL] = "|";
            }
            case 2 -> {
                hangmanDrawingMatrix[LEFT_ARM_COL][POST_COL - 1] = "|";
                hangmanDrawingMatrix[LEFT_ARM_COL - 1][POST_COL - 1] = "|";
                hangmanDrawingMatrix[TOP_ROW][POST_COL] = "_";
            }
            case 3 -> {
                hangmanDrawingMatrix[TOP_ROW][HEAD_COL - 1] = "_";
                hangmanDrawingMatrix[TOP_ROW][HEAD_COL + 1] = "_";
                hangmanDrawingMatrix[TOP_ROW][HEAD_COL] = "_";
                hangmanDrawingMatrix[LEFT_ARM_COL - 1][POST_COL + 5] = "|";
            }
            case 4 -> {
                hangmanDrawingMatrix[LEFT_ARM_COL][LEFT_ARM_COL] = "(";
                hangmanDrawingMatrix[LEFT_ARM_COL][RIGHT_ARM_COL] = ")";
                hangmanDrawingMatrix[RIGHT_ARM_COL][LEFT_ARM_COL] = "/";
                hangmanDrawingMatrix[RIGHT_ARM_COL][RIGHT_ARM_COL] = "\\";
            }
            case 5 -> {
                hangmanDrawingMatrix[BODY_COL][BODY_COL] = "|";
                hangmanDrawingMatrix[LEFT_LEG_COL][LEFT_LEG_COL] = "/";
                hangmanDrawingMatrix[RIGHT_LEG_COL][RIGHT_LEG_COL] = "\\";
            }
            default -> LOGGER.warning(String.format(UNEXPECTED_MISTAKES_MESSAGE, numberOfMistakes));
        }
    }

    public void clearDrawing() {
        for (String[] drawingMatrixRow : hangmanDrawingMatrix) {
            Arrays.fill(drawingMatrixRow, "");
        }
    }
}
