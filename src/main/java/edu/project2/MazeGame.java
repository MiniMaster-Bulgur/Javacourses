package edu.project2;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class MazeGame {

    private static final Logger LOGGER = Logger.getLogger(MazeGame.class.getName());

    private static final int WIDTH = 21;
    private static final int HEIGHT = 21;
    private static final char WALL = '#';
    private static final char PATH = ' ';
    private static final char UNVISITED = '-';
    private static final char PLAYER = '@';
    private static final char EXIT = 'E';

    private static final int DIRECTION_UP = 0;
    private static final int DIRECTION_RIGHT = 1;
    private static final int DIRECTION_DOWN = 2;
    private static final int DIRECTION_LEFT = 3;

    private final char[][] maze;
    private final Random random;
    private int playerX;
    private int playerY;

    public MazeGame() {
        maze = new char[HEIGHT][WIDTH];
        random = new Random();
        initializeMaze();
        generateMaze(1, 1);
        placePlayerAndExit();
    }

    private void initializeMaze() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x % 2 == 0 || y % 2 == 0) {
                    maze[y][x] = WALL;
                } else {
                    maze[y][x] = UNVISITED;
                }
            }
        }
    }

    private void generateMaze(int x, int y) {
        maze[y][x] = PATH;

        int[] directions = {DIRECTION_UP, DIRECTION_RIGHT, DIRECTION_DOWN, DIRECTION_LEFT};
        shuffle(directions);

        for (int direction : directions) {
            int nx = x;
            int ny = y;

            switch (direction) {
                case DIRECTION_UP:
                    ny -= 2;
                    break;
                case DIRECTION_RIGHT:
                    nx += 2;
                    break;
                case DIRECTION_DOWN:
                    ny += 2;
                    break;
                case DIRECTION_LEFT:
                    nx -= 2;
                    break;
                default:
                    LOGGER.warning("Unexpected direction value: " + direction);
            }

            if (nx > 0 && nx < WIDTH && ny > 0 && ny < HEIGHT && maze[ny][nx] == UNVISITED) {
                maze[(ny + y) / 2][(nx + x) / 2] = PATH;
                generateMaze(nx, ny);
            }
        }
    }

    private void shuffle(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private void placePlayerAndExit() {
        playerX = 1;
        playerY = 1;
        maze[playerY][playerX] = PLAYER;
        maze[HEIGHT - 2][WIDTH - 2] = EXIT;
    }

    public void printMaze() {
        StringBuilder mazeString = new StringBuilder();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                mazeString.append(maze[y][x]);
            }
            mazeString.append("\n");
        }
        LOGGER.info(mazeString.toString());
    }

    private boolean movePlayer(char direction) {
        int newX = playerX;
        int newY = playerY;

        switch (direction) {
            case 'w':
                newY--;
                break;
            case 's':
                newY++;
                break;
            case 'a':
                newX--;
                break;
            case 'd':
                newX++;
                break;
            default:
                LOGGER.warning("Unexpected move direction: " + direction);
                return false;
        }

        if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT && maze[newY][newX] != WALL) {
            maze[playerY][playerX] = PATH;

            playerX = newX;
            playerY = newY;

            if (maze[playerY][playerX] == EXIT) {
                return true;
            } else {
                maze[playerY][playerX] = PLAYER;
            }
        }

        return false;
    }

    /**
     * Для запуска игры
     */
    public static void main(String[] ignoredArgs) {
        MazeGame game = new MazeGame();
        Scanner scanner = new Scanner(System.in);

        boolean isExitReached = false;

        while (!isExitReached) {
            game.printMaze();
            LOGGER.info("Введите направление: ");

            String input = scanner.nextLine();

            if (input.length() != 1) {
                LOGGER.info("Пожалуйста, введите одну из букв - w a s d");
                continue;
            }

            char move = input.charAt(0);
            isExitReached = game.movePlayer(move);
        }

        LOGGER.info("Вы нашли выход!");

        scanner.close();
    }
}
