public class task1 {

        public static int minutesToSeconds(String timeStr) {
            try {

                String[] parts = timeStr.split(":");
                if (parts.length != 2)
                {
                    return -1;
                }
                int minutes = Integer.parseInt(parts[0]);
                int seconds = Integer.parseInt(parts[1]);
                if (seconds >= 60 || minutes < 0 || seconds < 0)
                {
                    return -1;
                }
                return minutes * 60 + seconds;
            }

            catch (NumberFormatException e)
            {
                return -1;
            }
        }
        public static void main(String[] args) {
            System.out.println(minutesToSeconds("104:23"));
        }
    }
