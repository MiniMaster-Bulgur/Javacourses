package edu.Hw2;

import edu.hw2.Task2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    public void testRectangle() {
        Task2.Rectangle rectangle = new Task2.Rectangle(5, 10);
        assertEquals(5, rectangle.getWidth());
        assertEquals(10, rectangle.getHeight());
        assertEquals(50, rectangle.getArea());

        Task2.Rectangle modifiedRectangle = rectangle.setWidth(15);
        assertEquals(15, modifiedRectangle.getWidth());
        assertEquals(10, modifiedRectangle.getHeight());
        assertEquals(150, modifiedRectangle.getArea());

        modifiedRectangle = modifiedRectangle.setHeight(20);
        assertEquals(15, modifiedRectangle.getWidth());
        assertEquals(20, modifiedRectangle.getHeight());
        assertEquals(300, modifiedRectangle.getArea());
    }

    @Test
    public void testSquare() {
        Task2.Square square = new Task2.Square(5);
        assertEquals(5, square.getWidth());
        assertEquals(5, square.getHeight());
        assertEquals(25, square.getArea());

        Task2.Rectangle modifiedSquare = square.setWidth(10);
        assertEquals(10, modifiedSquare.getWidth());
        assertEquals(10, modifiedSquare.getHeight());
        assertEquals(100, modifiedSquare.getArea());

        modifiedSquare = modifiedSquare.setHeight(15);
        assertEquals(15, modifiedSquare.getWidth());
        assertEquals(15, modifiedSquare.getHeight());
        assertEquals(225, modifiedSquare.getArea());
    }
}

