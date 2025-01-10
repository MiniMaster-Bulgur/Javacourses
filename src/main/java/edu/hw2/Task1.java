package edu.hw2;

public class Task1 {

    private Task1() {
    }

    public sealed interface Expr permits Constant, Negate, Exponent, Addition, Multiplication {
        double evaluate();
    }

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
}

