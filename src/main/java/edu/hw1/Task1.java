package edu.hw1;

    public class Task1 {


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

            if (seconds >= 60 || minutes < 0 || seconds < 0) {
                return -1;
            }

            return minutes * 60 + seconds;
        }
    }

