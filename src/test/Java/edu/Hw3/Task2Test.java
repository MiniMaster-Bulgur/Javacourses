package edu.Hw3;

import edu.hw3.Task2;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task2Test {

    @Test
    void testSimpleClusters() {
        List<String> result = Task2.clusterize("()()()");
        assertEquals(List.of("()", "()", "()"), result);
    }

    @Test
    void testNestedCluster() {
        List<String> result = Task2.clusterize("((()))");
        assertEquals(List.of("((()))"), result);
    }

    @Test
    void testMixedClusters() {
        List<String> result = Task2.clusterize("((()))(())()()(()())");
        assertEquals(List.of("((()))", "(())", "()", "()", "(()())"), result);
    }

    @Test
    void testComplexClusters() {
        List<String> result = Task2.clusterize("((())())(()(()()))");
        assertEquals(List.of("((())())", "(()(()()))"), result);
    }

    @Test
    void testEmptyString() {
        List<String> result = Task2.clusterize("");
        assertTrue(result.isEmpty());
    }

    @Test
    void testNullInput() {
        List<String> result = Task2.clusterize(null);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSinglePair() {
        List<String> result = Task2.clusterize("()");
        assertEquals(List.of("()"), result);
    }

    @Test
    void testDeepNesting() {
        List<String> result = Task2.clusterize("(((())))");
        assertEquals(List.of("(((())))"), result);
    }

    @Test
    void testMultipleComplexClusters() {
        List<String> result = Task2.clusterize("((()())())((()()))");
        assertEquals(List.of("((()())())", "((()()))"), result);
    }
}
