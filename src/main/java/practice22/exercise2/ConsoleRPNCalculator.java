package practice22.exercise2;

import practice22.exercise1.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConsoleRPNCalculator {
    public static void main(String[] args) {
        var rpnCalculator = new RPNCalculator();

        System.out.println("Введите выражение в обратной польской нотации:");
        System.out.print("> ");

        var userInput = new Scanner(System.in).nextLine();

        try {
            var operations = parseOperations(userInput);
            System.out.println("Результат: " + rpnCalculator.evaluate(operations));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (RPNEvaluationException e) {
            System.out.println("Ошибка вычисления: " + e.getCause());
        }
    }

    private static List<RPNOperation> parseOperations(String input) throws IllegalArgumentException {
        var inputTokenizer = new StringTokenizer(input);
        var operations = new ArrayList<RPNOperation>();

        while (inputTokenizer.hasMoreTokens()) {
            var token = inputTokenizer.nextToken();

            var number = tryParseDouble(token);
            if (number != null) {
                operations.add(new PushNumberOperation(number));
                continue;
            }

            var binaryOperation = switch (token) {
                case "+" -> BinaryOperation.ADD;
                case "-" -> BinaryOperation.SUBTRACT;
                case "*" -> BinaryOperation.MULTIPLY;
                case "/" -> BinaryOperation.DIVIDE;
                default -> throw new IllegalArgumentException("Неизвестная операция " + token);
            };

            operations.add(binaryOperation);
        }

        return operations;
    }

    private static Double tryParseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
