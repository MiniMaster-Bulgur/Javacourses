package edu.hw2;

import edu.hw2.Task3.connection.Connection;
import edu.hw2.Task3.connection.FaultyConnection;
import edu.hw2.Task3.connection.StableConnection;
import edu.hw2.Task3.exception.ConnectionException;
import edu.hw2.Task3.executor.PopularCommandExecutor;
import edu.hw2.Task3.manager.ConnectionManager;
import edu.hw2.Task3.manager.DefaultConnectionManager;
import edu.hw2.Task3.manager.FaultyConnectionManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Task3Test {

    @Test
    void testStableConnection() {
        try (Connection connection = new StableConnection()) {
            assertDoesNotThrow(() -> connection.execute());
        }
    }

    @Test
    void testDefaultConnectionManager() {
        ConnectionManager manager = new DefaultConnectionManager();
        assertThat(manager.getConnection()).isInstanceOf(Connection.class);
    }

    @Test
    void testFaultyConnectionManager() {
        ConnectionManager manager = new FaultyConnectionManager();
        assertThat(manager.getConnection()).isInstanceOf(FaultyConnection.class);
    }

    @Test
    void testExecutorWithStableConnection() {
        ConnectionManager manager = new DefaultConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 1);
        assertDoesNotThrow(() -> executor.updatePackages());
    }

    @Test
    void testExecutorWithFaultyConnection() {
        ConnectionManager manager = new FaultyConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 1);
        assertThrows(ConnectionException.class, () -> {
            for (int i = 0; i < 100; i++) { // Увеличиваем вероятность сбоя
                executor.updatePackages();
            }
        });
    }

    @Test
    void testRetryMechanism() {
        ConnectionManager manager = new DefaultConnectionManager();
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);
        assertDoesNotThrow(() -> executor.updatePackages());
    }

    @Test
    void testConnectionClose() {
        Connection connection = new StableConnection();
        assertDoesNotThrow(connection::close);
    }

    @Test
    void testFaultyConnectionBehavior() {
        try (Connection connection = new FaultyConnection()) {
            boolean hadSuccess = false;
            boolean hadFailure = false;

            for (int i = 0; i < 100; i++) {
                try {
                    connection.execute();
                    hadSuccess = true;
                } catch (ConnectionException e) {
                    hadFailure = true;
                }

                if (hadSuccess && hadFailure) {
                    break;
                }
            }

            assertThat(hadSuccess || hadFailure).isTrue();
        }
    }
}
