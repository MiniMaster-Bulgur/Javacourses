package edu.hw3.Task6;

public class Stock implements Comparable<Stock> {
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
        return "Stock{"
            + "name='" + name + '\''
            + ", price=" + price
            + '}';
    }
}
