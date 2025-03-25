package edu.hw1;

import java.util.Arrays;
import java.util.logging.Logger;

public class Task6 {

    private static final int KAPREKAR_CONSTANT = 6174;

    static {
        Logger.getLogger(Task6.class.getName());
    }

    private Task6() {
        throw new UnsupportedOperationException("Это служебный класс, и его экземпляр не может быть создан");
    }

    public static int countK(int n) {
        return countKHelper(n, 0);
    }

    private static int countKHelper(int n, int steps) {
        if (n == KAPREKAR_CONSTANT) {
            return steps;
        }

        String numStr = String.format("%04d", n);

        String descending = sortDescending(numStr);

        String ascending = sortAscending(numStr);

        int nextNumber = Integer.parseInt(descending) - Integer.parseInt(ascending);

        return countKHelper(nextNumber, steps + 1);
    }

    private static String sortDescending(String numStr) {
        char[] chars = numStr.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(new String(chars)).reverse().toString();
    }

    private static String sortAscending(String numStr) {
        char[] chars = numStr.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
