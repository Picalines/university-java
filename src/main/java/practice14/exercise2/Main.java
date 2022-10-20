package practice14.exercise2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var pattern = Pattern.compile("^abcdefghijklmnopqrstuv18340$");

        System.out.print("Введите строку:\n> ");
        var matcher = pattern.matcher(scanner.nextLine());
        System.out.println(matcher.find()
            ? "Да, является"
            : "Нет, не является");
    }
}
