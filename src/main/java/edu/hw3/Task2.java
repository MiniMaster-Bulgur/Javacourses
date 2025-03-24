package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public final class Task2 {

    private Task2() {

    }

    public static List<String> clusterize(String text) {
        if (text == null || text.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> clusters = new ArrayList<>();
        StringBuilder currentCluster = new StringBuilder();
        int balance = 0;

        for (char c : text.toCharArray()) {
            currentCluster.append(c);

            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }

            if (balance == 0 && !currentCluster.isEmpty()) {
                clusters.add(currentCluster.toString());
                currentCluster = new StringBuilder();
            }
        }

        return clusters;
    }
}
