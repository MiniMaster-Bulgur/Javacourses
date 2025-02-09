package edu.Hw3;

import edu.hw3.Task7;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {

    @Test
    public void testNullKey() {

        TreeMap<String, String> tree = new TreeMap<>(new Task7.NullSafeComparator());

        tree.put(null, "test");

        assertTrue(tree.containsKey(null), "");
    }
}
