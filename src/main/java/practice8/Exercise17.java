package practice8;

import java.util.Scanner;

public class Exercise17 {
    public static void main(String[] args) {
        var max = readMax(new Scanner(System.in));
        System.out.println(max);
    }

    // (max, count)
    public static int readMax(Scanner consoleReader) {
        var num = consoleReader.nextInt();
        if (num == 0) {
            return 0;
        }

        var recNum = readMax(consoleReader);
        return Math.max(num, recNum);
    }
}
