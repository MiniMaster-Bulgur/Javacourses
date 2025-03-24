package edu.hw1;

import org.apache.logging.log4j.LogManager;

public final class Task7 {

    static {
        LogManager.getLogger(Task7.class);
    }

    private Task7() {
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
