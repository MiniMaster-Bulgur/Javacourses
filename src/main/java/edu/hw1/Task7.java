package edu.hw1;

public class Task7 {

    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        int size = Integer.SIZE;
        int effectiveShift = shift % size;

        return (n << effectiveShift) | (n >>> (size - effectiveShift));
    }

    public static int rotateRight(int n, int shift) {
        int size = Integer.SIZE;
        int effectiveShift = shift % size;

        return (n >>> effectiveShift) | (n << (size - effectiveShift));
    }
}
