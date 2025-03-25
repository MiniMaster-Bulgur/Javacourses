package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

// Интерфейс StockMarket
public interface StockMarket {
    /** Добавить акцию */
    void add(Stock stock);

    /** Удалить акцию */
    void remove(Stock stock);

    /** Самая дорогая акция */
    Stock mostValuableStock();
}

// Класс Stock
class Stock implements Comparable<Stock> {
    private final String name;
    private final double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Stock other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return "Stock{" +
            "name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}

// Реализация интерфейса StockMarket
class StockMarketImpl implements StockMarket {
    private final PriorityQueue<Stock> stockQueue;

    public StockMarketImpl() {
        // Создаем PriorityQueue, которая упорядочивает акции по цене в порядке убывания
        this.stockQueue = new PriorityQueue<>(Comparator.comparingDouble(Stock::getPrice).reversed());
    }

    @Override
    public void add(Stock stock) {
        stockQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockQueue.peek();
    }
}

