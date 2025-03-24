package edu.hw1;

import java.util.logging.Logger;

public final class Task2 {

    static {
        Logger.getLogger(Task2.class.getName());
    }

    private static final int BASE_TEN = 10;

    private Task2() {

    }

    public static int countDigits(final int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;
        int tempNumber = number;
        while (tempNumber != 0) {
            tempNumber /= BASE_TEN;
            count++;
        }

        return count;
    }

    public static void main(final String[] ignoredArgs) {

    }
}


