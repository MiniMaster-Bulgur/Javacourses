package edu.hw2;

public sealed interface Expr permits Constant, Negate, Exponent, Addition, Multiplication {
    double evaluate();
}

    package edu.hw2;

public record Constant(double value) implements Expr {
    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

    package edu.hw2;

public record Negate(Expr expr) implements Expr {
    @Override
    public double evaluate() {
        return -expr.evaluate();
    }

    @Override
    public String toString() {
        return "-(" + expr + ")";
    }
}

    package edu.hw2;

public record Exponent(Expr base, int exponent) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(base.evaluate(), exponent);
    }

    @Override
    public String toString() {
        return base + "^" + exponent;
    }
}

    package edu.hw2;

public record Addition(Expr left, Expr right) implements Expr {
    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}

    package edu.hw2;

public record Multiplication(Expr left, Expr right) implements Expr {
    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }
}
