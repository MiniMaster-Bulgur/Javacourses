package edu.Hw2;

import edu.hw2.Task3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {

    @Test
    public void testStableConnection() {
        Task3.ConnectionManager manager = new Task3.DefaultConnectionManager();
        Task3.PopularCommandExecutor executor = new Task3.PopularCommandExecutor(manager, 3);

    }

    @Test
    public void testFaultyConnection() {
        Task3.ConnectionManager manager = new Task3.FaultyConnectionManager();
        Task3.PopularCommandExecutor executor = new Task3.PopularCommandExecutor(manager, 3);

    }

    @Test
    public void testMaxAttemptsExceeded() {
        Task3.ConnectionManager manager = new Task3.FaultyConnectionManager();
        Task3.PopularCommandExecutor executor = new Task3.PopularCommandExecutor(manager, 1);
    }
}
