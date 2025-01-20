package edu.hw2;

import edu.hw2.task1.expression.Addition;
import edu.hw2.task1.expression.Constant;
import edu.hw2.task1.expression.Expr;
import edu.hw2.task1.expression.Exponent;
import edu.hw2.task1.expression.Multiplication;
import edu.hw2.task1.expression.Negate;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void testConstant() {
        Expr constant = new Constant(5);
        assertThat(constant.evaluate()).isEqualTo(5.0);
    }

    @Test
    void testNegate() {
        Expr negation = new Negate(new Constant(5));
        assertThat(negation.evaluate()).isEqualTo(-5.0);
    }

    @Test
    void testExponent() {
        Expr exponent = new Exponent(new Constant(2), 3);
        assertThat(exponent.evaluate()).isEqualTo(8.0);
    }

    @Test
    void testAddition() {
        Expr addition = new Addition(new Constant(5), new Constant(3));
        assertThat(addition.evaluate()).isEqualTo(8.0);
    }

    @Test
    void testMultiplication() {
        Expr multiplication = new Multiplication(new Constant(4), new Constant(2));
        assertThat(multiplication.evaluate()).isEqualTo(8.0);
    }

    @Test
    void testComplexExpression() {
        Expr complex = new Exponent(
            new Negate(
                new Multiplication(
                    new Addition(
                        new Constant(2),
                        new Constant(4)
                    ),
                    new Constant(1)
                )
            ),
            2
        );
        assertThat(complex.evaluate()).isEqualTo(36.0);
    }

    @Test
    void testToString() {
        Expr expr = new Addition(new Constant(2), new Multiplication(new Constant(3), new Constant(4)));
        assertThat(expr.toString()).isEqualTo();
    }
}
