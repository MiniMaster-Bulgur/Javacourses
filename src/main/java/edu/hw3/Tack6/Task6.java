package edu.hw3.Tack6;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class Task6 {

    private final PriorityQueue<Equity> equityQueue;
    private Equity equity;

    public Task6() {
        equityQueue = new PriorityQueue<>(Comparator.comparingDouble(Equity::getPrice).reversed());
    }

    public void add(Equity equity) {
        this.equity = equity;
        equityQueue.add(equity);
    }

    public void remove(Equity equity) {
        this.equity = equity;
        equityQueue.remove(equity);
    }

    public Equity mostValuableEquity() {
        return equityQueue.peek();
    }

    public Equity getEquity() {
        return equity;
    }

    public void setEquity(Equity equity) {
        this.equity = equity;
    }
}
