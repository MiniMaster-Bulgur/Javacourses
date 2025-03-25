package edu.hw2.task1.expression;

public sealed interface Expr permits Constant, Negate, Exponent, Addition, Multiplication {
    double evaluate();
}
