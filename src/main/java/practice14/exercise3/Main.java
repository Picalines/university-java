package practice14.exercise3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        var costPattern = Pattern.compile("(?<value>\\d+(\\.\\d{1,2})?)\\s+(?<currency>USD|RUB|EU)");

        var text = inputText(new Scanner(System.in));

        var costMatcher = costPattern.matcher(text);
        if (!costMatcher.find()) {
            System.out.println("Цены не найдены");
            return;
        }

        System.out.println("Найденные цены:");
        do
        {
            System.out.println(costMatcher.group());
        } while (costMatcher.find());
    }

    private static String inputText(Scanner scanner) {
        var textBuilder = new StringBuilder();
        System.out.println("Введите текст (пустая строка для окончания):");

        String line;
        while ((line = scanner.nextLine()).length() > 0) {
            textBuilder.append(line).append('\n');
        }

        return textBuilder.toString();
    }
}
