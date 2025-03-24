package edu.project2;

import java.util.Random;
import java.util.Scanner;

public class MazeGame {

    private static final int WIDTH = 21;
    private static final int HEIGHT = 21;
    private static final char WALL = '#';
    private static final char PATH = ' ';
    private static final char UNVISITED = '-';
    private static final char PLAYER = '@';
    private static final char EXIT = 'E';

    private final char[][] maze;
    private final Random random;
    private int playerX, playerY;

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

        int[] directions = {0, 1, 2, 3};
        shuffle(directions);

        for (int direction : directions) {
            int nx = x;
            int ny = y;

            switch (direction) {
                case 0: // Вверх
                    ny -= 2;
                    break;
                case 1: // Вправо
                    nx += 2;
                    break;
                case 2: // Вниз
                    ny += 2;
                    break;
                case 3: // Влево
                    nx -= 2;
                    break;
            }

            if (nx > 0 && nx < WIDTH && ny > 0 && ny < HEIGHT && maze[ny][nx] == UNVISITED) {
                maze[(ny + y) / 2][(nx + x) / 2] = PATH; // Пробиваем стену между клетками
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
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(maze[y][x]);
            }
            System.out.println();
        }
    }

    private boolean movePlayer(char direction) {
        int newX = playerX, newY = playerY;

        switch (direction) {
            case 'w': // Up
                newY--;
                break;
            case 's': // Down
                newY++;
                break;
            case 'a': // Left
                newX--;
                break;
            case 'd': // Right
                newX++;
                break;
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

    public static void main(String[] ignoredArgs) {
        MazeGame game = new MazeGame();
        Scanner scanner = new Scanner(System.in);

        boolean isExitReached = false;

        while (!isExitReached) {

            game.printMaze();

            System.out.println("Введите направление: ");

            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите одну из букв - w a s d");
                continue;
            }

            char move = input.charAt(0);
            isExitReached = game.movePlayer(move);
        }

        System.out.println("Вы нашли выход!");

        scanner.close();
    }
}
