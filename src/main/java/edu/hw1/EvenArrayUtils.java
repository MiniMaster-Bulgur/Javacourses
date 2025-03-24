package edu.hw1;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Утилитарный класс для работы с массивами целых чисел.
 */
public final class EvenArrayUtils {

    private static final Logger LOGGER = LogManager.getLogger();

    private EvenArrayUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Фильтрует массив целых чисел, возвращая только четные числа.
     *
     * @param numbers массив целых чисел для фильтрации
     * @return массив четных чисел из исходного массива
     * @throws NullPointerException если входной массив равен null
     */
    public static int[] filter(final int[] numbers) {
        Objects.requireNonNull(numbers);
        LOGGER.trace("Filtering an array {}", numbers);

        int count = count(numbers);

        int[] result = new int[count];
        int idx = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                result[idx++] = number;
            }
        }
        return result;
    }

    /**
     * Подсчитывает количество четных чисел в массиве целых чисел.
     *
     * @param numbers массив целых чисел для подсчета
     * @return количество четных чисел в массиве
     * @throws NullPointerException если входной массив равен null
     */
    public static int count(final int[] numbers) {
        Objects.requireNonNull(numbers);

        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                ++count;
            }
        }
        return count;
    }
}
