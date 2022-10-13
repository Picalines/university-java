package practice8;

import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        printOdd(new Scanner(System.in));
    }

    public static void printOdd(Scanner consoleReader) {
        var num = consoleReader.nextInt();
        if (num == 0) return;

        System.out.println(num);

        num = consoleReader.nextInt();
        if (num != 0) {
            printOdd(consoleReader);
        }
    }
}
