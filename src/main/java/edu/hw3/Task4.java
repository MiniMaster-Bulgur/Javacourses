package edu.hw3;
public class Task4 {
    public static String convertToRoman(int number) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException();
        }

        return thousands[number/1000] +
            hundreds[(number%1000)/100] +
            tens[(number%100)/10] +
            ones[number%10];
    }
}
