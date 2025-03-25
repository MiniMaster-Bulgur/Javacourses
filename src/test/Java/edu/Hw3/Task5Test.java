package edu.Hw3;

import edu.hw3.Task5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @Test
    void testSortNames() {

        String[] mainChars = {
            "Эрен Йегер",
            "Микаса Аккерман",
            "Армин Арлерт",
            "Леви Аккерман"
        };
        String[] expectedMain = {
            "Микаса Аккерман",
            "Леви Аккерман",
            "Армин Арлерт",
            "Эрен Йегер"
        };
        assertArrayEquals(expectedMain, Task5.sortNames(mainChars, "ASC"));

        String[] scouts = {
            "Жан Кирштейн",
            "Райнер Браун",
            "Энни Леонхарт",
            "Саша Браус"
        };
        String[] expectedScouts = {
            "Райнер Браун",
            "Саша Браус",
            "Жан Кирштейн",
            "Энни Леонхарт"
        };
        assertArrayEquals(expectedScouts, Task5.sortNames(scouts, "DESC"));

        String[] singles = {
            "Эрен",
            "Микаса",
            "Леви",
            "Армин"
        };
        String[] expectedSingles = {
            "Эрен",
            "Микаса",
            "Леви",
            "Армин"
        };
        assertArrayEquals(expectedSingles, Task5.sortNames(singles, "ASC"));
        assertArrayEquals(new String[]{}, Task5.sortNames(new String[]{}, "DESC"));
        assertArrayEquals(new String[]{}, Task5.sortNames(null, "DESC"));
    }
}
