package edu.Hw2;

import edu.hw2.Task1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Task1Test {


@Test
    public void testConstant() {
        Task1.Expr expr = new Task1.Constant(5);
        assertEquals(5, expr.evaluate());
    }

    @Test
    public void testNegate() {
        Task1.Expr expr = new Task1.Negate(new Task1.Constant(5));
        assertEquals(-5, expr.evaluate());
    }

    @Test
    public void testExponent() {
        Task1.Expr expr = new Task1.Exponent(new Task1.Constant(2), 3);
        assertEquals(8, expr.evaluate());
    }

    @Test
    public void testAddition() {
        Task1.Expr expr;
        expr = new Task1.Addition(new Task1.Constant(2), new Task1.Constant(3));
        assertEquals(5, expr.evaluate());
    }

    @Test
    public void testMultiplication() {
        Task1.Expr expr = new Task1.Multiplication(new Task1.Constant(2), new Task1.Constant(3));
        assertEquals(6, expr.evaluate());
    }

    @Test
    public void testComplexExpression() {
        Task1.Expr two = new Task1.Constant(2);
        Task1.Expr four = new Task1.Constant(4);
        Task1.Expr negOne = new Task1.Negate(new Task1.Constant(1));
        Task1.Expr sumTwoFour = new Task1.Addition(two, four);
        Task1.Expr mult = new Task1.Multiplication(sumTwoFour, negOne);
        Task1.Expr exp = new Task1.Exponent(mult, 2);
        Task1.Expr res = new Task1.Addition(exp, new Task1.Constant(1));
        assertEquals(37, res.evaluate());
    }
   }
