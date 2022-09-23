package practice3_new.part1;

import java.util.Arrays;
import java.util.Random;

public class Exercise1 {
    public static void main(String[] args) {
        var random = new Random();

        var array = new double[random.nextInt(1, 11)];

        System.out.println("array (len: " + array.length + "):");
        for (int i = 0; i < array.length; i++) {
            array[i] = i % 2 == 0
                ? random.nextDouble(0, 101)
                : Math.random() * 100;

            System.out.println(array[i]);
        }

        Arrays.sort(array);

        System.out.println("sorted:");
        for (var element : array) {
            System.out.println(element);
        }
    }
}
