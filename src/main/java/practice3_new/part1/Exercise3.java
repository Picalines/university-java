package practice3_new.part1;

import java.util.Random;

public class Exercise3 {
    public static void main(String[] args) {
        var random = new Random();

        var array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10, 100);
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println("is increasing: " + isIncreasing(array));
    }

    private static boolean isIncreasing(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
