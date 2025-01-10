package edu.hw1;

public class Task2 {
    private Task2() {
    }

    private static final int YOU = 10;

    public static int razrad(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;
        int tempNumber = number;
        while (tempNumber != 0) {
            tempNumber /= YOU;
            count++;
        }

        return count;
    }
}
