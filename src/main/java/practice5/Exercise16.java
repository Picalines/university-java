package practice5;

import java.util.Scanner;

public class Exercise16 {
    record Pair<F, S>(F first, S second) {}

    public static void main(String[] args) {
        var count = countMaxes(new Scanner(System.in));
        System.out.println("max: " + count.first);
        System.out.println("count: " + count.second);
    }

    // (max, count)
    public static Pair<Integer, Integer> countMaxes(Scanner consoleReader) {
        var num = consoleReader.nextInt();
        if (num == 0) {
            return new Pair<>(0, 1);
        }

        var recData = countMaxes(consoleReader);

        if (num > recData.first) {
            return new Pair<>(num, 1);
        }

        if (num == recData.first) {
            return new Pair<>(num, recData.second + 1);
        }

        return recData;
    }
}
