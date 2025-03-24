package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public final class Task1 {

    private static final Map<Character, Character> LOWER_MAP = new HashMap<>();
    private static final Map<Character, Character> UPPER_MAP = new HashMap<>();
    private static final int ALPHABET_SIZE = 25;

    private Task1() {
        // Private constructor to prevent instantiation
    }

    static {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < lower.length(); i++) {
            LOWER_MAP.put(lower.charAt(i), lower.charAt(ALPHABET_SIZE - i));
        }

        for (int i = 0; i < upper.length(); i++) {
            UPPER_MAP.put(upper.charAt(i), upper.charAt(ALPHABET_SIZE - i));
        }
    }

    public static String atbash(String text) {
        if (text == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(LOWER_MAP.get(c));
            } else if (Character.isUpperCase(c)) {
                result.append(UPPER_MAP.get(c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

