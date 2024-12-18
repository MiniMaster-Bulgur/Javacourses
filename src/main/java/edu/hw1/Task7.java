package edu.hw1;

/**
 * Task7: Implements bitwise rotation of integers to the left and right.
 */
public class Task7 {

    /**
     * Main method to test the rotateLeft and rotateRight methods.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(rotateRight(8, 1));
    }

    /**
     * Rotates the bits of an integer to the left by a specified number of positions.
     *
     * @param n     the integer whose bits will be rotated
     * @param shift the number of positions to rotate
     * @return the result of the left bitwise rotation
     */
    public static int rotateLeft(int n, int shift) {
        int size = Integer.SIZE;
        shift %= size;

        return (n << shift) | (n >>> (size - shift));
    }

    /**
     * Rotates the bits of an integer to the right by a specified number of positions.
     *
     * @param n     the integer whose bits will be rotated
     * @param shift the number of positions to rotate
     * @return the result of the right bitwise rotation
     */
    public static int rotateRight(int n, int shift) {
        int size = Integer.SIZE;
        shift %= size;

        return (n >>> shift) | (n << (size - shift));
    }
}
