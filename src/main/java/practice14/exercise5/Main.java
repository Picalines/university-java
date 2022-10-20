package practice14.exercise5;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        var regexBuilder = new StringBuilder();

        var startDate = LocalDate.parse("1990-01-01");
        var endDate = LocalDate.parse("9999-12-31");

        System.out.println("building regex...");
        regexBuilder.append('^');

        for (var date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
            regexBuilder
                .append('(')
                .append(leftPadZeros(date.getDayOfMonth(), 2))
                .append('/')
                .append(leftPadZeros(date.getMonthValue(), 2))
                .append('/')
                .append(date.getYear())
                .append(")|");
        }

        regexBuilder.append("(31/12/9999)$");

        System.out.println("compiling...");
        var pattern = Pattern.compile(regexBuilder.toString());

        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите дату (mm/dd/yyyy):\n> ");
            var inputLine = scanner.nextLine();
            if (inputLine.isEmpty()) {
                System.out.println("[Выход]");
                return;
            }

            var matcher = pattern.matcher(inputLine);

            System.out.println(matcher.find()
                ? "Дата корректна"
                : "Некорректная дата");
        }
    }

    private static String leftPadZeros(int number, int length) {
        return String.format("%0" + length + "d", number);
    }
}
