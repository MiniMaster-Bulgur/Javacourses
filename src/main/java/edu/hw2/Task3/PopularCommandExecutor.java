package edu.hw2.Task3;

import edu.hw2.Task3.connection.Connection;
import edu.hw2.Task3.exception.ConnectionException;
import edu.hw2.Task3.manager.ConnectionManager;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute();
    }

    private void tryExecute() {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute();
                return;
            } catch (Exception e) {
                attempts++;
                if (attempts == maxAttempts) {
                    throw new ConnectionException("Failed after " + maxAttempts + " attempts", e);
                }
            }
        }
    }
}
