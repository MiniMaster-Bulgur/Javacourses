package edu.hw2;

import java.util.Random;

public class Task3 {

    private Task3() {
    }

    public interface Connection extends AutoCloseable {
        void execute(String command) throws ConnectionException;
    }

    public static class StableConnection implements Connection {
        @Override
        public void execute(String command) {
        }

        @Override
        public void close() {
        }
    }

    public static class FaultyConnection implements Connection {
        private final Random random = new Random();

        @Override
        public void execute(String command) throws ConnectionException {
        }

        @Override
        public void close() {
        }
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static class DefaultConnectionManager implements ConnectionManager {
        private final Random random = new Random();

        @Override
        public Connection getConnection() {
            if (random.nextBoolean()) {
                return new StableConnection();
            } else {
                return new FaultyConnection();
            }
        }
    }

    public static class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public static class ConnectionException extends RuntimeException {
        public ConnectionException(String message) {
            super(message);
        }

        public ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
            this.manager = manager;
            this.maxAttempts = maxAttempts;
        }

        public void tryExecute(String command) throws ConnectionException {
            int attempts = 0;
            while (attempts < maxAttempts) {
                try (Connection connection = manager.getConnection()) {
                    connection.execute(command);
                    return;
                } catch (ConnectionException e) {
                    attempts++;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
