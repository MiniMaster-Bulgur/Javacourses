package edu.Hw3.Tack6;

import edu.hw3.Tack6.Equity;
import edu.hw3.Tack6.Task6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquityTest {

    private Equity equity;

    @BeforeEach
    void setUp() {
        equity = new Equity("TestEquity", 100.0);
    }

    @Test
    void testGetName() {
        Assertions.assertEquals("TestEquity", equity.getName());
    }

    @Test
    void testGetPrice() {
        Assertions.assertEquals(100.0, equity.getPrice(), 0.001);
    }
}

class Task6Test {

    private Task6 task6;
    private Equity equity1;
    private Equity equity2;

    @BeforeEach
    void setUp() {
        task6 = new Task6();
        equity1 = new Equity("Equity1", 150.0);
        equity2 = new Equity("Equity2", 200.0);
    }

    @Test
    void testAddAndMostValuableEquity() {
        task6.add(equity1);
        task6.add(equity2);
        Assertions.assertEquals(equity2, task6.mostValuableEquity());
    }

    @Test
    void testRemove() {
        task6.add(equity1);
        task6.add(equity2);
        task6.remove(equity2);
        Assertions.assertEquals(equity1, task6.mostValuableEquity());
    }

    @Test
    void testMostValuableEquityEmpty() {
        Assertions.assertNull(task6.mostValuableEquity());
    }
}
