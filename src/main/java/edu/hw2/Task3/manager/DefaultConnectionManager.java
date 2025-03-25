package edu.hw2.Task3.manager;

import edu.hw2.Task3.connection.Connection;
import edu.hw2.Task3.connection.FaultyConnection;
import edu.hw2.Task3.connection.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final double PROBABILITY_THRESHOLD = 0.5;
    private final Random random = new Random();

    @Override
    public Connection getConnection() {
        return random.nextDouble() > PROBABILITY_THRESHOLD ? new StableConnection() : new FaultyConnection();
    }
}
