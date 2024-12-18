package edu.hw1;

    /**
     * Task2: Counts the number of digits in a given integer.
     */
    public class Task2 {

        /**
         * Counts the number of digits in a non-negative integer.
         *
         * @param number the integer whose digits will be counted
         * @return the number of digits in the integer
         */
        public static int countDigits(int number) {
            if (number == 0) {
                return 1;
            }

            int count = 0;
            while (number != 0) {
                number /= 10;
                count++;
            }

            return count;
        }

        /**
         * Main method to test the countDigits method.
         *
         * @param args command-line arguments
         */
        public static void main(String[] args) {
            System.out.println(countDigits(233));
        }
    }
