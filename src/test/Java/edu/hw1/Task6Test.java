package edu.hw1;

import edu.hw1.Task6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void testKaprekarSteps() {
        assertEquals(3, Task6.kaprekarSteps(8764)); // Стандартный случай
    }

    @Test
    void testKaprekarStepsKaprekarNumber() {
        assertEquals(0, Task6.kaprekarSteps(6174)); // Уже число Капрекара
    }

    @Test
    void testKaprekarStepsDescending() {
        assertEquals(7, Task6.kaprekarSteps(5432)); // Максимальное количество шагов
    }

    @Test
    void testKaprekarStepsAscending() {
        assertEquals(5, Task6.kaprekarSteps(1000)); // Пример с нулями
    }
}
