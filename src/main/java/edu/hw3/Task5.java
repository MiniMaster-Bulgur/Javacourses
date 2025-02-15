package edu.hw3;

import java.util.Arrays;

public class Task5 {
    public static String[] sortNames(String[] names, String sortOrder) {

        if (names == null || names.length == 0) {
            return new String[0];
        }

        String[] result = names.clone();

        Arrays.sort(result, (a, b) -> {
            String lastNameA = getLastName(a);
            String lastNameB = getLastName(b);

            return sortOrder.equals("ASC")
                ? lastNameA.compareToIgnoreCase(lastNameB)
                : lastNameB.compareToIgnoreCase(lastNameA);
        });

        return result;
    }

    private static String getLastName(String fullName) {
        String[] parts = fullName.split(" ");

        return parts.length > 1 ? parts[parts.length - 1] : fullName;
    }
}
