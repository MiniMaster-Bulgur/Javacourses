package edu.hw1;


public final class Task3 {


    public static boolean isNestable(final int[] a1, final int[] a2) {
        int minA1 = Integer.MAX_VALUE;
        int maxA1 = Integer.MIN_VALUE;
        int minA2 = Integer.MAX_VALUE;
        int maxA2 = Integer.MIN_VALUE;

        for (int num : a1) {
            if (num < minA1) {
                minA1 = num;
            }
            if (num > maxA1) {
                maxA1 = num;
            }
        }

        for (int num : a2) {
            if (num < minA2) {
                minA2 = num;
            }
            if (num > maxA2) {
                maxA2 = num;
            }
        }

        return (minA1 > minA2) && (maxA1 < maxA2);
    }
}
