package edu.hw3.Tack6;

public final class Equity {
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

