package edu.hw1;

    public class Task4 {

        public static String fixString(String input) {
            char[] chars = input.toCharArray();

            for (int i = 1; i < chars.length; i += 2) {
                char temp = chars[i];
                chars[i] = chars[i - 1];
                chars[i - 1] = temp;
            }

            return new String(chars);
        }
    }
