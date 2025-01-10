package edu.hw1;


    public class Task1 {
        private Task1() {
        }

        private static final int NUMBER = 60;

        public static int minutesToSeconds(String timeStr) {
            String[] parts = timeStr.split(":");
            if (parts.length != 2) {
                return -1;
            }

            int minutes;
            int seconds;

            try {
                minutes = Integer.parseInt(parts[0]);
                seconds = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                return -1;
            }

            if (seconds >= NUMBER || minutes < 0 || seconds < 0) {
                return -1;
            }

            return minutes * NUMBER + seconds;
        }
    }
