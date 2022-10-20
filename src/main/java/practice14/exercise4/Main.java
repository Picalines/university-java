package practice14.exercise4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var pattern = Pattern.compile("(?<!\\+)\\d");

        System.out.print("Введите строку:\n> ");
        var matcher = pattern.matcher(scanner.nextLine());

        System.out.println(matcher.find()
            ? "Да, присутствуют"
            : "Отсутствуют");
    }
}
