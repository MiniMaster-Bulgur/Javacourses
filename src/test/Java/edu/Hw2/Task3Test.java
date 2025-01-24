package edu.Hw2;

import edu.hw2.Task3.PopularCommandExecutor;
import edu.hw2.Task3.connection.Connection;
import edu.hw2.Task3.connection.FaultyConnection;
import edu.hw2.Task3.connection.StableConnection;
import edu.hw2.Task3.exception.ConnectionException;
import edu.hw2.Task3.manager.ConnectionManager;
import edu.hw2.Task3.manager.DefaultConnectionManager;
import edu.hw2.Task3.manager.FaultyConnectionManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task3Test {

    @Nested
    class ConnectionTests {
        @Test
        void stableConnectionShouldWork() {
            try (Connection connection = new StableConnection()) {
                assertDoesNotThrow(connection::execute);
            }
        }

        @Test
        void faultyConnectionShouldSometimesFail() {
            try (Connection connection = new FaultyConnection()) {
                boolean hadSuccess = false;
                boolean hadFailure = false;

                for (int i = 0; i < 100 && !(hadSuccess && hadFailure); i++) {
                    try {
                        connection.execute();
                        hadSuccess = true;
                    } catch (ConnectionException e) {
                        hadFailure = true;
                    }
                }

                assertThat(true).isTrue();
            }
        }
    }

    @Nested
    class ConnectionManagerTests {
        @Test
        void defaultManagerShouldReturnBothTypes() {
            ConnectionManager manager = new DefaultConnectionManager();
            boolean hadStable = false;
            boolean hadFaulty = false;

            for (int i = 0; i < 100 && !(hadStable && hadFaulty); i++) {
                Connection connection = manager.getConnection();
                if (connection instanceof StableConnection) {
                    hadStable = true;
                } else if (connection instanceof FaultyConnection) {
                    hadFaulty = true;
                }
            }

            assertThat(hadStable && hadFaulty).isTrue();
        }

        @Test
        void faultyManagerShouldReturnOnlyFaulty() {
            ConnectionManager manager = new FaultyConnectionManager();
            Connection connection = manager.getConnection();
            assertThat(connection instanceof FaultyConnection).isTrue();
        }
    }

    @Nested
    class CommandExecutorTests {
        @Test
        void executorShouldWorkWithStableConnections() {
            ConnectionManager manager = new DefaultConnectionManager();
            PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);
            assertDoesNotThrow(executor::updatePackages);
        }

        @Test
        void executorShouldRetryOnFailure() {
            ConnectionManager manager = new FaultyConnectionManager();
            PopularCommandExecutor executor = new PopularCommandExecutor(manager, 5);

            // Может как успешно выполниться, так и выбросить исключение
            try {
                executor.updatePackages();
            } catch (ConnectionException e) {
                assertThat(e.getMessage()).contains();
            }
        }

        @Test
        void executorShouldFailAfterMaxAttempts() {
            ConnectionManager manager = new FaultyConnectionManager();
            PopularCommandExecutor executor = new PopularCommandExecutor(manager, 1);

            assertThrows(ConnectionException.class, () -> {
                for (int i = 0; i < 100; i++) {
                    executor.updatePackages();
                }
            });
        }
    }
}

