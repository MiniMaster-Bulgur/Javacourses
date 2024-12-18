public class task2 {
    public static int inventor(int number) {
        if (number == 0)
        {
            return 1;
        }

        int count = 0;
        while (number != 0)
        {
            number /= 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(inventor(233));
    }
}
