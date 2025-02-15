package edu.hw3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Task6 {

    private PriorityQueue<Equity> equityQueue;

    public Task6() {
        equityQueue = new PriorityQueue<>(Comparator.comparingDouble(Equity::getPrice).reversed());
    }

    public void add(Equity equity) {
        equityQueue.add(equity);
    }

    public void remove(Equity equity) {
        equityQueue.remove(equity);
    }

    public Equity mostValuableEquity() {
        return equityQueue.peek();
    }
}

class Equity {
    private final String name;
    private final double price;

    public Equity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
