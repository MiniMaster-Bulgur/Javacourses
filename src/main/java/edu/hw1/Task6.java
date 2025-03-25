package edu.hw1;

import java.util.Arrays;
import java.util.logging.Logger;

public class Task6 {

    static {
        Logger.getLogger(Task6.class.getName());
    }

    public static int countK(int n) {
        return countKHelper(n, 0);
    }

    private static int countKHelper(int n, int steps) {
        if (n == 6174) {
            return steps;
        }

        // Преобразуем число в строку для сортировки цифр
        String numStr = String.format("%04d", n); // Убедимся, что число имеет 4 цифры

        // Формируем число с цифрами в порядке убывания
        String descending = sortDescending(numStr);

        // Формируем число с цифрами в порядке возрастания
        String ascending = sortAscending(numStr);

        // Вычисляем разность
        int nextNumber = Integer.parseInt(descending) - Integer.parseInt(ascending);

        // Рекурсивно вызываем функцию для следующего числа
        return countKHelper(nextNumber, steps + 1);
    }

    private static String sortDescending(String numStr) {
        char[] chars = numStr.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(new String(chars)).reverse().toString();
    }

    private static String sortAscending(String numStr) {
        char[] chars = numStr.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
