package edu.hw1;
    /**
     * Task3: Determines if one array can be nested inside another array.
     */
    public class Task3 {

        /**
         * Checks if array a1 can be nested inside array a2.
         * An array a1 is nestable inside a2 if:
         * - The minimum of a1 is greater than the minimum of a2.
         * - The maximum of a1 is less than the maximum of a2.
         *
         * @param a1 the first array to be checked
         * @param a2 the second array to compare against
         * @return true if a1 can be nested inside a2; otherwise false
         */
        public static boolean isNestable(int[] a1, int[] a2) {
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

        /**
         * Main method to test the isNestable method.
         *
         * @param args command-line arguments
         */
        public static void main(String[] args) {
            System.out.println(isNestable(new int[]{2, 1, 1, 2}, new int[]{0, 3}));
        }
    }
