package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task3 {

    private Task3() {
        // Private constructor to prevent instantiation
    }

    public static <T> Map<T, Integer> freqDict(List<T> items) {
        if (items == null) {
            return new HashMap<>();
        }

        Map<T, Integer> frequencyMap = new HashMap<>();

        for (T item : items) {
            frequencyMap.merge(item, 1, Integer::sum);
        }

        return frequencyMap;
    }
}
