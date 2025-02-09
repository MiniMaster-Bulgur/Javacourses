package edu.hw3;
import java.util.HashMap;
import java.util.Map;

public class Task1 {

    private static final Map<Character, Character> lowerMap = new HashMap<>();
    private static final Map<Character, Character> upperMap = new HashMap<>();

    static {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < lower.length(); i++) {
            lowerMap.put(lower.charAt(i), lower.charAt(25 - i));
        }

        for (int i = 0; i < upper.length(); i++) {
            upperMap.put(upper.charAt(i), upper.charAt(25 - i));
        }
    }

    public static String atbash(String text) {
        if (text == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(lowerMap.get(c));
            } else if (Character.isUpperCase(c)) {
                result.append(upperMap.get(c));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

