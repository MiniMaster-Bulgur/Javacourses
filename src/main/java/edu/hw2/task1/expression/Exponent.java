package edu.hw2.task1.expression;

import java.util.logging.Logger;

public record Exponent(Expr base, int exponent) implements Expr {
    private static final Logger LOGGER = Logger.getLogger(Exponent.class.getName());

    @Override
    public double evaluate() {
        double result = Math.pow(base.evaluate(), exponent);
        LOGGER.info("Evaluating Exponent: " + base + "^" + exponent + " = " + result);
        return result;
    }

    @Override
    public String toString() {
        return base + "^" + exponent;
    }
}
