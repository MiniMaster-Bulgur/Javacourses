package edu.hw4;

public class Animal {
    private final String name;
    private final Type type;
    private final Sex sex;
    private final int age;
    private final int height;
    private final int weight;
    private final boolean bites;

    private static final int CAT_DOG_PAWS = 4;
    private static final int BIRD_PAWS = 2;
    private static final int FISH_PAWS = 0;
    private static final int SPIDER_PAWS = 8;

    public Animal(String name, Type type, Sex sex, int age, int height, int weight, boolean bites) {
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bites = bites;
    }

    public enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    public enum Sex {
        M, F
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public boolean getBites() {
        return bites;
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> CAT_DOG_PAWS;
            case BIRD -> BIRD_PAWS;
            case FISH -> FISH_PAWS;
            case SPIDER -> SPIDER_PAWS;
        };
    }
}
