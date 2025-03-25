package edu.project_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class MazeGameTest {

    private MazeGame mazeGame;

    @BeforeEach
    public void setUp() {
        mazeGame = new MazeGame();
        JFrame frame = new JFrame();
        frame.add(mazeGame);
        frame.pack();
        frame.setVisible(true);
    }

    @Test
    public void testInitialPosition() {
        assertEquals(1, mazeGame.getPlayerX(), "Начальная позиция X игрока неверна");
        assertEquals(1, mazeGame.getPlayerY(), "Начальная позиция Y игрока неверна");
    }

    @Test
    public void testMovePlayerRight() {
        KeyEvent rightArrow = new KeyEvent(mazeGame, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, 'R');
        mazeGame.keyPressed(rightArrow);

        assertEquals(2, mazeGame.getPlayerX(), "Игрок не переместился вправо");
        assertEquals(1, mazeGame.getPlayerY(), "Позиция Y игрока изменилась неправильно при движении вправо");
    }
}
