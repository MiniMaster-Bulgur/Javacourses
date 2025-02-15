package edu.Hw3;
import edu.hw3.Task3;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task3Test {
    @Test
    void testFreqDict() {

        assertEquals(
            Map.of("bb", 2, "a", 2),
            Task3.freqDict(Arrays.asList("a", "bb", "a", "bb"))
        );

        assertEquals(
            Map.of("that", 1, "and", 2, "this", 1),
            Task3.freqDict(Arrays.asList("this", "and", "that", "and"))
        );

        assertEquals(
            Map.of("код", 3, "bug", 1),
            Task3.freqDict(Arrays.asList("код", "код", "код", "bug"))
        );

        assertEquals(
            Map.of(1, 2, 2, 2),
            Task3.freqDict(Arrays.asList(1, 1, 2, 2))
        );

        assertEquals(
            Map.of(1.1, 2, 2.2, 1, 3.3, 1),
            Task3.freqDict(Arrays.asList(1.1, 1.1, 2.2, 3.3))
        );

        assertTrue(Task3.freqDict(List.of()).isEmpty());
        assertTrue(Task3.freqDict(null).isEmpty());
        assertEquals(Map.of("single", 1), Task3.freqDict(List.of("single")));

        assertEquals(
            Map.of("Test", 2, "test", 1, "TEST", 1),
            Task3.freqDict(Arrays.asList("Test", "test", "TEST", "Test"))
        );
    }
}
