package edu.hw1;


public final class Task2 {


    public static int countDigits(final int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;
        int tempNumber = number;
        while (tempNumber != 0) {
            tempNumber /= 10;
            count++;
        }

        return count;
    }

    public static void main(final String[] ignoredArgs) {
        System.out.println(countDigits(233));
    }
}

