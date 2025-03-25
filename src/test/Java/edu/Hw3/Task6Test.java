package edu.Hw3;

import static org.junit.jupiter.api.Assertions.*;
import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import edu.hw3.Task6.StockMarketImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockMarketImplTest {

    private StockMarket stockMarket;
    private Stock stock1;
    private Stock stock2;
    private Stock stock3;

    @BeforeEach
    void setUp() {
        stockMarket = new StockMarketImpl();
        stock1 = new Stock("Stock1", 100.0);
        stock2 = new Stock("Stock2", 200.0);
        stock3 = new Stock("Stock3", 150.0);
    }

    @Test
    void testAddAndMostValuableStock() {
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        assertEquals(stock2, stockMarket.mostValuableStock());
    }

    @Test
    void testRemove() {
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.remove(stock2);
        assertEquals(stock1, stockMarket.mostValuableStock());
    }

    @Test
    void testMostValuableStockEmpty() {
        assertNull(stockMarket.mostValuableStock());
    }

    @Test
    void testMultipleStocks() {
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        stockMarket.add(stock3);
        assertEquals(stock2, stockMarket.mostValuableStock());
        stockMarket.remove(stock2);
        assertEquals(stock3, stockMarket.mostValuableStock());
    }
}

