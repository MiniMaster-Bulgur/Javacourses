package edu.Hw3;
import edu.hw3.Equity;
import edu.hw3.Task6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {

    @Test
    public void testMostValuableEquity() {
        Task6 market = new Task6();

        Equity apple = new Equity("Apple", 150.0);
        Equity google = new Equity("Google", 2800.0);
        Equity amazon = new Equity("Amazon", 3400.0);

        market.add(apple);
        market.add(google);
        market.add(amazon);

        assertEquals("Amazon", market.mostValuableEquity().getName());

        market.remove(amazon);

        assertEquals("Google", market.mostValuableEquity().getName());
    }
}
