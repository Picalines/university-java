package practice8;

import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        printDigits(scanner.nextInt());
    }

    public static void printDigits(int num) {
        var lastDigit = num % 10;
        if ((num /= 10) != 0) {
            printDigits(num);
        }

        System.out.print(lastDigit);
        System.out.print(' ');
    }
}
