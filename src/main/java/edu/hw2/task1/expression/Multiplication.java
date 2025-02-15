package edu.hw2.task1.expression;

import java.util.logging.Logger;

public record Multiplication(Expr left, Expr right) implements Expr {
    private static final Logger LOGGER = Logger.getLogger(Multiplication.class.getName());

    @Override
    public double evaluate() {
        double result = left.evaluate() * right.evaluate();
        LOGGER.info(STR."Evaluating Multiplication: \{left} * \{right} = \{result}");
        return result;
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }
}
