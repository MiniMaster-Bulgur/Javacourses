package edu.hw1;

import edu.hw3.Equity;
import java.util.Arrays;
import java.util.logging.Logger;

public final class Task6 {

    static {
        Logger.getLogger(Task6.class.getName());
    }

    private static final int KAPREKAR_CONSTANT = 6174;

    Task6() {

    }


    public static int kaprekarSteps(final int n) {
        if (n == KAPREKAR_CONSTANT) {
            return 0;
        }

        String numStr = String.format("%04d", n);
        char[] digits = numStr.toCharArray();

        Arrays.sort(digits);
        String ascStr = new String(digits);
        String descStr = new StringBuilder(ascStr).reverse().toString();

        int asc = Integer.parseInt(ascStr);
        int desc = Integer.parseInt(descStr);
        int nextNumber = desc - asc;

        return 1 + kaprekarSteps(nextNumber);
    }

    public void add(Equity ignoredApple) {
    }

    public Equity mostValuableEquity() {
        return null;
    }
}
