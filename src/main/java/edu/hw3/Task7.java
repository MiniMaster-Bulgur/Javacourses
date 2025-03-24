package edu.hw3;

import java.util.Comparator;
import java.util.Objects;

public final class Task7 {

    private Task7() {

    }


    public static class NullSafeComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (Objects.equals(o1, o2)) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o1.compareTo(o2);
        }
    }
}
