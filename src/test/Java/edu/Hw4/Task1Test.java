package edu.Hw4;

import edu.hw4.Animal;
import edu.hw4.Task1;
import edu.hw4.ValidationError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    private List<Animal> animals;

    @BeforeEach
    void setUp() {
        animals = new ArrayList<>(Arrays.asList(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false),
            new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.M, 3, 50, 10, true),
            new Animal("Small Bird", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 1, false),
            new Animal("Golden Fish", Animal.Type.FISH, Animal.Sex.F, 2, 5, 1, false),
            new Animal("Black Widow", Animal.Type.SPIDER, Animal.Sex.F, 1, 3, 0, true)
        ));
    }

    @Test
    void testSortByHeight() {
        List<Animal> sorted = Task1.sortByHeight(animals);
        assertEquals("Black Widow", sorted.get(0).getName());
        assertEquals("Golden Fish", sorted.get(1).getName());
        assertEquals("Small Bird", sorted.get(2).getName());
        assertEquals("Cat", sorted.get(3).getName());
        assertEquals("Big Dog", sorted.get(4).getName());
    }

    @Test
    void testSortByWeightAndSelectTopK() {
        List<Animal> topK = Task1.sortByWeightAndSelectTopK(animals, 2);
        assertEquals(2, topK.size());
        assertEquals("Big Dog", topK.get(0).getName());
        assertEquals("Cat", topK.get(1).getName());
    }

    @Test
    void testCountAnimalsByType() {
        Map<Animal.Type, Long> counts = Task1.countAnimalsByType(animals);
        assertEquals(1, counts.get(Animal.Type.CAT));
        assertEquals(1, counts.get(Animal.Type.DOG));
        assertEquals(1, counts.get(Animal.Type.BIRD));
        assertEquals(1, counts.get(Animal.Type.FISH));
        assertEquals(1, counts.get(Animal.Type.SPIDER));
    }

    @Test
    void testGetAnimalWithLongestName() {
        Animal result = Task1.getAnimalWithLongestName(animals);
        assertEquals("Golden Fish", result.getName());
    }

    @Test
    void testGetMoreCommonSex() {
        Animal.Sex result = Task1.getMoreCommonSex(animals);
        assertEquals(Animal.Sex.F, result);
    }

    @Test
    void testGetHeaviestAnimalPerType() {
        Map<Animal.Type, Animal> heaviest = Task1.getHeaviestAnimalPerType(animals);
        assertEquals("Cat", heaviest.get(Animal.Type.CAT).getName());
        assertEquals("Big Dog", heaviest.get(Animal.Type.DOG).getName());
        assertEquals("Small Bird", heaviest.get(Animal.Type.BIRD).getName());
    }

    @Test
    void testGetKthOldestAnimal() {
        Animal result = Task1.getKthOldestAnimal(animals, 1);
        assertEquals("Cat", result.getName());
    }

    @Test
    void testGetHeaviestAnimalBelowHeight() {
        Optional<Animal> result = Task1.getHeaviestAnimalBelowHeight(animals, 40);
        assertTrue(result.isPresent());
        assertEquals("Cat", result.get().getName());
    }

    @Test
    void testGetTotalPaws() {
        Integer result = Task1.getTotalPaws(animals);
        assertEquals(18, result);
    }

    @Test
    void testGetAnimalsWithAgeNotMatchingPaws() {
        List<Animal> result = Task1.getAnimalsWithAgeNotMatchingPaws(animals);
        assertTrue(result.stream().anyMatch(a -> a.getName().equals("Cat")));
    }

    @Test
    void testGetBitingAnimalsAbove100cm() {
        List<Animal> result = Task1.getBitingAnimalsAbove100cm(animals);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCountAnimalsWithWeightGreaterThanHeight() {
        Long result = Task1.countAnimalsWithWeightGreaterThanHeight(animals);
        assertEquals(0L, result);
    }

    @Test
    void testGetAnimalsWithNamesLongerThanTwoWords() {
        List<Animal> result = Task1.getAnimalsWithNamesLongerThanTwoWords(animals);
        assertTrue(result.isEmpty());
    }

    @Test
    void testHasDogTallerThanK() {
        Boolean result = Task1.hasDogTallerThanK(animals, 40);
        assertTrue(result);
    }

    @Test
    void testGetTotalWeightPerTypeInAgeRange() {
        Map<Animal.Type, Integer> result = Task1.getTotalWeightPerTypeInAgeRange(animals, 1, 3);
        assertEquals(10, result.get(Animal.Type.DOG));
    }

    @Test
    void testSortAnimalsByTypeSexName() {
        List<Animal> result = Task1.sortAnimalsByTypeSexName(animals);
        assertEquals("Small Bird", result.get(0).getName())
    }

    @Test
    void testDoSpidersBiteMoreThanDogs() {
        Boolean result = Task1.doSpidersBiteMoreThanDogs(animals);
        assertFalse(result);
    }

    @Test
    void testGetHeaviestFishInMultipleLists() {
        List<List<Animal>> multipleLists = Arrays.asList(
            animals,
            Arrays.asList(new Animal("Big Fish", Animal.Type.FISH, Animal.Sex.M, 3, 10, 2, false))
        );
        Animal result = Task1.getHeaviestFishInMultipleLists(multipleLists);
        assertEquals("Big Fish", result.getName());
    }

    @Test
    void testInvalidAnimals() {
        Animal invalidAnimal = new Animal("", Animal.Type.CAT, Animal.Sex.M, -1, -5, -5, false);
        List<Animal> testAnimals = Arrays.asList(invalidAnimal);

        Set<ValidationError> errors = Task1.validateAnimal(invalidAnimal);
        assertFalse(errors.isEmpty());

        boolean hasNameError = errors.stream()
            .anyMatch(e -> e.getFieldName().equals("name") &&
                e.getMessage().equals("Name cannot be empty"));
        boolean hasAgeError = errors.stream()
            .anyMatch(e -> e.getFieldName().equals("age") &&
                e.getMessage().equals("Age cannot be negative"));
        boolean hasHeightError = errors.stream()
            .anyMatch(e -> e.getFieldName().equals("height") &&
                e.getMessage().equals("Height must be positive"));
        boolean hasWeightError = errors.stream()
            .anyMatch(e -> e.getFieldName().equals("weight") &&
                e.getMessage().equals("Weight must be positive"));

        assertTrue(hasNameError);
        assertTrue(hasAgeError);
        assertTrue(hasHeightError);
        assertTrue(hasWeightError);
    }

    @Test
    void testValidAnimal() {
        Animal validAnimal = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 30, 5, false);
        Set<ValidationError> errors = Task1.validateAnimal(validAnimal);
        assertTrue(errors.isEmpty());
    }
}
