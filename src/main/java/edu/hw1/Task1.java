package edu.hw1;

   /**
     * Task1: Converts time from the format "MM:SS" to total seconds.
     */
    public class Task1 {

        /**
         * Converts a time string in the format "MM:SS" to total seconds.
         *
         * @param timeStr the time string in "MM:SS" format
         * @return the total time in seconds, or -1 if the format is invalid
         */
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

        /**
         * Main method to test the minutesToSeconds method.
         *
         * @param args command-line arguments
         */
        public static void main(String[] args) {
            System.out.println(minutesToSeconds("104:23"));
        }
    }

