package practice14.exercise7;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d_]{8,}$");

        System.out.print("Введите пароль:\n> ");
        var matcher = pattern.matcher(scanner.nextLine());

        System.out.println(matcher.find()
            ? "Пароль надежный"
            : "Пароль ненадёжный");
    }
}
