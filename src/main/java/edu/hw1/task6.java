public class task6 {
    public static void main(String[] args) {
        int number = 8764;
        int steps = kaprekarSteps(number);
        System.out.println("Количество шагов: " + steps);
    }

    public static int kaprekarSteps(int n) {
        if (n == 6174) {
            return 0;
        }

        String numStr = String.format("%04d", n);
        char[] digits = numStr.toCharArray();

        java.util.Arrays.sort(digits);
        String ascStr = new String(digits);
        String descStr = new StringBuilder(ascStr).reverse().toString();

        int asc = Integer.parseInt(ascStr);
        int desc = Integer.parseInt(descStr);

        int nextNumber = desc - asc;

        return 1 + kaprekarSteps(nextNumber);
    }
}
