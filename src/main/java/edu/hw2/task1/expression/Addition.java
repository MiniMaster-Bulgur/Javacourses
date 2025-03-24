package edu.hw2.task1.expression;

import java.util.logging.Logger;

public record Addition(Expr left, Expr right) implements Expr {
    private static final Logger LOGGER = Logger.getLogger(Addition.class.getName());
    private static final String PLUS = "+";

    @Override
    public double evaluate() {
        double result = left.evaluate() + right.evaluate();
        LOGGER.info("Evaluating Addition: " + left + " " + PLUS + " " + right + " = " + result);
        return result;
    }

    @Override
    public String toString() {
        return "(" + left + " " + PLUS + " " + right + ")";
    }
}

