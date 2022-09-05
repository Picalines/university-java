package practice5;

import java.util.Scanner;

public class Exercise15 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        printDigits(scanner.nextInt());
    }

    public static void printDigits(int num) {
        System.out.print(num % 10);
        System.out.print(' ');

        if ((num /= 10) != 0) {
            printDigits(num);
        }
    }
}
