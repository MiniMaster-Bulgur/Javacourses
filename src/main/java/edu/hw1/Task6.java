package edu.hw1;

import java.util.Arrays;

/**
 * Task6: Calculates the number of steps to reach Kaprekar's constant (6174).
 */
public class Task6 {

    /**
     * Main method to execute the Kaprekar steps calculation.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int number = 8764;
        int steps = kaprekarSteps(number);
        System.out.println("Количество шагов: " + steps);
    }

    /**
     * Recursively calculates the number of steps to reach Kaprekar's constant (6174).
     * The method sorts the digits of the number in ascending and descending order,
     * calculates their difference, and repeats the process.
     *
     * @param n the input number to perform the Kaprekar operation on
     * @return the number of steps to reach 6174
     */
    public static int kaprekarSteps(int n) {
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
