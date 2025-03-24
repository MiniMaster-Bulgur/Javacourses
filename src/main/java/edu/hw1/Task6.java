package edu.hw1;

import java.util.Arrays;
import java.util.logging.Logger;


public final class Task6 {

    private static final Logger LOGGER = Logger.getLogger(Task6.class.getName());

    public static void main(final String[] ignoredArgs) {
        final int number = 8764;
        final int steps = kaprekarSteps(number);
        LOGGER.info("Количество шагов: " + steps);
    }


    public static int kaprekarSteps(final int n) {
        if (n == 6174) {
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
}
