package edu.hw2.task1.expression;

import java.util.logging.Logger;

public record Negate(Expr expr) implements Expr {
    private static final Logger LOGGER = Logger.getLogger(Negate.class.getName());

    @Override
    public double evaluate() {
        double result = -expr.evaluate();
        LOGGER.info("Evaluating Negate: -(" + expr + ") = " + result);
        return result;
    }

    @Override
    public String toString() {
        return "-(" + expr + ")";
    }
}
