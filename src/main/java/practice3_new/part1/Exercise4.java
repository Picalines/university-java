package practice3_new.part1;

import java.util.Random;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Введите количество элементов массива: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Некорректный ввод!");
            }
        } while (n <= 0);

        var array = new int[n];
        var evens = new int[n];
        int nEvens = 0;

        var random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(0, n + 1);

            if (array[i] % 2 == 0) {
                evens[nEvens++] = array[i];
            }

            System.out.print(array[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < nEvens; i++) {
            System.out.print(evens[i] + " ");
        }
    }
}
