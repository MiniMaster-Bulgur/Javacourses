package edu.hw3;

public final class Task4 {

    private static final int MAX_ROMAN_NUMBER = 3999;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;
    private static final int TEN = 10;

    private Task4() {

    }

    public static String convertToRoman(int number) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        if (number <= 0 || number > MAX_ROMAN_NUMBER) {
            throw new IllegalArgumentException();
        }

        return thousands[number / THOUSAND]
            + hundreds[(number % THOUSAND) / HUNDRED]
            + tens[(number % HUNDRED) / TEN]
            + ones[number % TEN];
    }
}
