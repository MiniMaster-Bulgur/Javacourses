package edu.hw4;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    // Задача 1
    public static List<Animal> sortByHeight(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::getHeight))
            .toList();
    }

    // Задача 2:
    public static List<Animal> sortByWeightAndSelectTopK(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::getWeight).reversed())
            .limit(k)
            .toList();
    }

    // Задача 3
    public static Map<Animal.Type, Long> countAnimalsByType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::getType, Collectors.counting()));
    }

    // Задача 4
    public static Animal getAnimalWithLongestName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(a -> a.getName().length()))
            .orElse(null);
    }

    // Задача 5
    public static Animal.Sex getMoreCommonSex(List<Animal> animals) {
        Map<Animal.Sex, Long> sexCount = animals.stream()
            .collect(Collectors.groupingBy(Animal::getSex, Collectors.counting()));

        Long maleCount = sexCount.getOrDefault(Animal.Sex.M, 0L);
        Long femaleCount = sexCount.getOrDefault(Animal.Sex.F, 0L);

        return maleCount >= femaleCount ? Animal.Sex.M : Animal.Sex.F;
    }

    // Задача 6
    public static Map<Animal.Type, Animal> getHeaviestAnimalPerType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::getType,
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingInt(Animal::getWeight)),
                    opt -> opt.orElse(null)
                )
            ));
    }

    // Задача 7
    public static Animal getKthOldestAnimal(List<Animal> animals, int k) {
        if (k <= 0 || k > animals.size()) {
            return null;
        }
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::getAge).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    // Задача 8
    public static Optional<Animal> getHeaviestAnimalBelowHeight(List<Animal> animals, int k) {
        return animals.stream()
            .filter(a -> a.getHeight() < k)
            .max(Comparator.comparingInt(Animal::getWeight));
    }

    // Задача 9
    public static Integer getTotalPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    // Задача 10
    public static List<Animal> getAnimalsWithAgeNotMatchingPaws(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.getAge() != a.paws())
            .toList();
    }

    // Задача 11
    public static List<Animal> getBitingAnimalsAbove100cm(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.getBites() && a.getHeight() > 100)
            .toList();
    }

    // Задача 12
    public static Long countAnimalsWithWeightGreaterThanHeight(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.getWeight() > a.getHeight())
            .count();
    }

    // Задача 13
    public static List<Animal> getAnimalsWithNamesLongerThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.getName().split("\\s+").length > 2)
            .toList();
    }

    // Задача 14
    public static Boolean hasDogTallerThanK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(a -> a.getType() == Animal.Type.DOG && a.getHeight() > k);
    }

    // Задача 15
    public static Map<Animal.Type, Integer> getTotalWeightPerTypeInAgeRange(
        List<Animal> animals, int k, int l
    ) {
        return animals.stream()
            .filter(a -> a.getAge() >= k && a.getAge() <= l)
            .collect(Collectors.groupingBy(
                Animal::getType,
                Collectors.summingInt(Animal::getWeight)
            ));
    }

    // Задача 16
    public static List<Animal> sortAnimalsByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator
                .comparing(Animal::getType)
                .thenComparing(Animal::getSex)
                .thenComparing(Animal::getName))
            .toList();
    }

    // Задача 17
    public static Boolean doSpidersBiteMoreThanDogs(List<Animal> animals) {
        Map<Animal.Type, Long> bitingAnimals = animals.stream()
            .filter(Animal::getBites)
            .collect(Collectors.groupingBy(Animal::getType, Collectors.counting()));

        long spiderBites = bitingAnimals.getOrDefault(Animal.Type.SPIDER, 0L);
        long dogBites = bitingAnimals.getOrDefault(Animal.Type.DOG, 0L);

        return spiderBites > dogBites;
    }

    // Задача 18
    public static Animal getHeaviestFishInMultipleLists(List<List<Animal>> animalLists) {
        return animalLists.stream()
            .flatMap(List::stream)
            .filter(a -> a.getType() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::getWeight))
            .orElse(null);
    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        if (animal.getName() == null || animal.getName().isEmpty()) {
            errors.add(new ValidationError("name", "Имя не может быть пустым"));
        }
        if (animal.getAge() < 0) {
            errors.add(new ValidationError("age", "Возраст не может быть отрицательным"));
        }
        if (animal.getHeight() <= 0) {
            errors.add(new ValidationError("height", "Высота должна быть положительной"));
        }
        if (animal.getWeight() <= 0) {
            errors.add(new ValidationError("weight", "Вес должен быть положительным"));
        }

        return errors;
    }

}

