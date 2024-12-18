package edu.hw1;
    /**
     * Task4: Swaps adjacent characters in a string.
     */
    public class Task4 {

        /**
         * Fixes the input string by swapping adjacent characters.
         * For example, "abcd" becomes "badc".
         *
         * @param input the input string
         * @return the string with adjacent characters swapped
         */
        public static String fixString(String input) {
            char[] chars = input.toCharArray();

            for (int i = 1; i < chars.length; i += 2) {
                char temp = chars[i];
                chars[i] = chars[i - 1];
                chars[i - 1] = temp;
            }

            return new String(chars);
        }

        /**
         * Main method to test the fixString method.
         *
         * @param args command-line arguments
         */
        public static void main(String[] args) {
            System.out.println(fixString("оккша"));
        }
    }
