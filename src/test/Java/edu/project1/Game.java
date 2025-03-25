package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import proect.proect1.Game;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testWinScenario() {
        String userInput = "a\np\nl\ne\n";
        scanner = new Scanner(userInput);

        Game.Result result = game.playGame(scanner);

        assertEquals(0, result.getMistakesCount(), "Количество ошибок должно быть 0");
        assertTrue(result.getCorrectGuesses() > 0, "Должны быть правильные угадывания");
    }

    @Test
    public void testLoseScenario() {
        String userInput = "z\nx\nc\nv\nb\nn\n";
        scanner = new Scanner(userInput);

        Game.Result result = game.playGame(scanner);

        assertEquals(Game.MAX_MISTAKES, result.getMistakesCount(), "Количество ошибок должно достичь максимума");
        assertEquals(0, result.getCorrectGuesses(), "Не должно быть правильных угадываний");
    }
}
