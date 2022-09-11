package lab1;

public class Variant3 {
    public static void main(String[] args) {
        final int count = 10;
        for (int n = 1; n <= count; n++) {
            System.out.println("[" + n + "/" + count + "] " + harmonic(n));
        }
    }

    private static double harmonic(int n) {
        return 1.0 / n;
    }
}
