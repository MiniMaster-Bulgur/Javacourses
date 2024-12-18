public class task7 {
    public static void main(String[] args) {
        System.out.println(rotateRight(8, 1));
    }

    public static int rotateLeft(int n, int shift) {
        int size = Integer.SIZE;
        shift %= size;

        return (n << shift) | (n >>> (size - shift));
    }

    public static int rotateRight(int n, int shift) {
        int size = Integer.SIZE;
        shift %= size;

        return (n >>> shift) | (n << (size - shift));
    }
}

