package practice25.exercise3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        var onePartRegex = "(\\d{1,2}|[01]\\d{2}|2[0-4]\\d|25[0-5])";

        var idPattern = Pattern.compile(onePartRegex + "\\."
            + onePartRegex + "\\." + onePartRegex + "\\." + onePartRegex);

        System.out.print("Введите IP адрес:\n> ");
        var input = new Scanner(System.in).nextLine();

        System.out.println(idPattern.matcher(input).matches()
            ? "Введённая строка является IP адресом"
            : "Введённая строка не является IP адресом");
    }
}
