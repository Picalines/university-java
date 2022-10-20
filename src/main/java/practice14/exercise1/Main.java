package practice14.exercise1;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Введите строку:\n> ");
        var stringToMatch = scanner.nextLine();

        Pattern regex = tryWhileException(
            () -> {
                System.out.print("Введите регулярное выражение:\n> ");
                return Pattern.compile(scanner.nextLine());
            },
            exception -> {
                if (!(exception instanceof PatternSyntaxException syntaxException)) {
                    throw new RuntimeException(exception);
                }

                System.out.println("Ошибка в синтаксисе регулярного выражения:");
                System.out.println(syntaxException.getDescription());
            }
        );

        var matcher = regex.matcher(stringToMatch);
        if (!matcher.find()) {
            System.out.println("Подходящие подстроки не найдены");
            return;
        }

        System.out.println("Подходящие подстроки:");
        do {
            System.out.println(matcher.group().length() == 0
                ? "<пустая строка>"
                : matcher.group());
        } while ((matcher.find()));
    }

    private static <T> T tryWhileException(Supplier<T> supplier, Consumer<Exception> exceptionHandler) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception exception) {
                exceptionHandler.accept(exception);
            }
        }
    }
}
