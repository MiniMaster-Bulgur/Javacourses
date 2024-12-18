public class task5 {
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeDescendant(int num) {
        String numStr = Integer.toString(num);

        while (numStr.length() > 1) {
            if (isPalindrome(numStr)) {
                return true;
            }

            StringBuilder descendant = new StringBuilder();
            for (int i = 0; i < numStr.length() - 1; i += 2) {
                int sum = Character.getNumericValue(numStr.charAt(i)) + Character.getNumericValue(numStr.charAt(i + 1));
                descendant.append(sum);
            }

            numStr = descendant.toString();
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeDescendant(23336014));
        System.out.println(isPalindromeDescendant(12));
    }
}
