package practice25.exercise4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите выражение со скобками:\n> ");
        var expression = new Scanner(System.in).nextLine();

        int parenBalance = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                parenBalance++;
            }

            if (expression.charAt(i) == ')') {
                parenBalance--;
                if (parenBalance < 0) {
                    System.out.println("Ошибка: у закрывающей скобки нет открывающей");
                    return;
                }
            }
        }

        if (parenBalance != 0) {
            System.out.println("Ошибка: у открывающей скобки нет закрывающей");
            return;
        }

        System.out.println("Скобки в выражении сбалансированы");
    }
}
