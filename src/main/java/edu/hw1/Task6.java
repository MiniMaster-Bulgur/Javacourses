package edu.hw1;

public class Task6 {

    private Task6() {
    }

    private static final int NUMBER_OF_DIGITS = 4;
    private static final int CONST_NUMBER = 6174;

    public static int count(int n) {
        String numStr = String.valueOf(n);
        if (numStr.length() != NUMBER_OF_DIGITS) {
            return -1;
        }
        return process(n, 0);
    }

    private static void sortArray(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static int process(int n, int steps) {
        if (n == CONST_NUMBER) {
            return steps;
        }

        String num = String.valueOf(n);
        char[] array = num.toCharArray();
        sortArray(array);

        String up = new String(array);
        String down = new StringBuilder(up).reverse().toString();

        int upNum = Integer.parseInt(up);
        int downNum = Integer.parseInt(down);

        int diff = downNum - upNum;

        return process(diff, steps + 1);
    }
}
