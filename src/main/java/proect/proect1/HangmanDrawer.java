package proect.proect1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

public class HangmanDrawer {

    private static final Logger LOGGER = Logger.getLogger(HangmanDrawer.class.getName());
    private static final int MATRIX_SIZE = 8;

    private static int baseRow;
    private static int postCol;
    private static int topRow;
    private static int headCol;
    private static int bodyCol;
    private static int leftArmCol;
    private static int rightArmCol;
    private static int leftLegCol;
    private static int rightLegCol;

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
            baseRow = Integer.parseInt(properties.getProperty("BASE_ROW"));
            postCol = Integer.parseInt(properties.getProperty("POST_COL"));
            topRow = Integer.parseInt(properties.getProperty("TOP_ROW"));
            headCol = Integer.parseInt(properties.getProperty("HEAD_COL"));
            bodyCol = Integer.parseInt(properties.getProperty("BODY_COL"));
            leftArmCol = Integer.parseInt(properties.getProperty("LEFT_ARM_COL"));
            rightArmCol = Integer.parseInt(properties.getProperty("RIGHT_ARM_COL"));
            leftLegCol = Integer.parseInt(properties.getProperty("LEFT_LEG_COL"));
            rightLegCol = Integer.parseInt(properties.getProperty("RIGHT_LEG_COL"));
        } catch (IOException ex) {
            LOGGER.severe("Error loading config file: %s".formatted(ex.getMessage()));
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

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4; // Обратите внимание на исправление "fore" на "four"
    private static final int FIVE = 5;

    public void updateHangmanDrawingMatrix(int numberOfMistakes) {
        switch (headCol) {

            case ONE -> {
                hangmanDrawingMatrix[baseRow][postCol - 2] = "/";
                hangmanDrawingMatrix[baseRow][postCol - 1] = "-";
                hangmanDrawingMatrix[baseRow][postCol] = "\\";
                hangmanDrawingMatrix[baseRow - 1][postCol] = "|";
                hangmanDrawingMatrix[baseRow - 2][postCol] = "|";
                hangmanDrawingMatrix[baseRow][postCol] = "|";
                hangmanDrawingMatrix[baseRow][postCol] = "|";
            }

            case TWO -> {
                hangmanDrawingMatrix[leftArmCol][postCol - 1] = "|";
                hangmanDrawingMatrix[leftArmCol - 1][postCol - 1] = "|";
                hangmanDrawingMatrix[topRow][postCol] = "_";
            }

            case THREE -> {
                hangmanDrawingMatrix[topRow][headCol - 1] = "_";
                hangmanDrawingMatrix[topRow][headCol + 1] = "_";
                hangmanDrawingMatrix[topRow][headCol] = "_";
                hangmanDrawingMatrix[leftArmCol - 1][postCol] = "|";
            }

            case FOUR -> {
                hangmanDrawingMatrix[leftArmCol][leftArmCol] = "(";
                hangmanDrawingMatrix[leftArmCol][rightArmCol] = ")";
                hangmanDrawingMatrix[rightArmCol][leftArmCol] = "/";
                hangmanDrawingMatrix[rightArmCol][rightArmCol] = "\\";
            }

            case FIVE -> {
                hangmanDrawingMatrix[bodyCol][bodyCol] = "|";
                hangmanDrawingMatrix[leftLegCol][leftLegCol] = "/";
                hangmanDrawingMatrix[rightLegCol][rightLegCol] = "\\";
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
