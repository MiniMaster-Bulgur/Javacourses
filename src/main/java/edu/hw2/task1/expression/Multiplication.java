package edu.hw2.task1.expression;

import java.util.logging.Logger;

public record Multiplication(Expr left, Expr right) implements Expr {
    private static final Logger LOGGER = Logger.getLogger(Multiplication.class.getName());
    private static final String MULTIPLY = "*";

    @Override
    public double evaluate() {
        double result = left.evaluate() * right.evaluate();
        LOGGER.info(() -> "Evaluating Multiplication: " + left + " " + MULTIPLY + " " + right + " = " + result);
        return result;
    }

    @Override
    public String toString() {
        return "(" + left + " " + MULTIPLY + " " + right + ")";
    }
}

