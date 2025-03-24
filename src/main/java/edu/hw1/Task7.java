package edu.hw1;


public final class Task7 {

    public static void main(String[] ignoredArgs) {
        System.out.println(rotateRight(8, 1));
    }


    public static int rotateLeft(final int n, final int shift) {
        final int size = Integer.SIZE;
        int adjustedShift = shift % size;

        return (n << adjustedShift) | (n >>> (size - adjustedShift));
    }


    public static int rotateRight(final int n, final int shift) {
        final int size = Integer.SIZE;
        int adjustedShift = shift % size;

        return (n >>> adjustedShift) | (n << (size - adjustedShift));
    }
}
