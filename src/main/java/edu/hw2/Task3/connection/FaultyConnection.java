package edu.hw2.Task3.connection;

import edu.hw2.Task3.exception.ConnectionException;
import java.util.Random;

public class FaultyConnection implements Connection {
    private static final double FAILURE_PROBABILITY = 0.5;
    private final Random random = new Random();

    @Override
    public void execute() {
        if (random.nextDouble() < FAILURE_PROBABILITY) {
            throw new ConnectionException("Connection failed", null);
        }
    }

    @Override
    public void close() {
    }
}
