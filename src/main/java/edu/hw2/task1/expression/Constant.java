package edu.hw2.task1.expression;

import java.util.logging.Logger;

public record Constant(double value) implements Expr {
    private static final Logger LOGGER = Logger.getLogger(Constant.class.getName());

    @Override
    public double evaluate() {
        LOGGER.info("Evaluating Constant with value: " + value);
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
