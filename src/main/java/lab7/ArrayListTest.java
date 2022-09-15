package lab7;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        final int N = 30;

        int max = -1;

        System.out.print("Elements: ");
        var random = new Random();
        for (int i = 0; i < N; i++) {
            var element = random.nextInt(100);
            numbers.add(element);
            System.out.print(element);
            System.out.print(' ');

            max = Math.max(max, element);
        }

        System.out.print("\nOdds: ");
        for (int i = 1; i < N; i += 2) {
            System.out.print(numbers.get(i));
            System.out.print(' ');
        }

        System.out.print("\nMax: " + max + " (at index " + numbers.indexOf(max) + ")");
    }
}
