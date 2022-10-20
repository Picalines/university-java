package practice14.exercise9;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        var wordPattern = Pattern.compile("[a-zA-Z]+");
        var wordCounts = new HashMap<String, Integer>();
        int totalWordCount = 0;

        var text = inputText(new Scanner(System.in));
        var wordMatcher = wordPattern.matcher(text);

        while (wordMatcher.find()) {
            var word = wordMatcher.group();
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            totalWordCount++;
        }

        System.out.println("Словарь частот:");
        for (var entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + (entry.getValue().doubleValue() / totalWordCount));
        }
    }

    private static String inputText(Scanner scanner) {
        var textBuilder = new StringBuilder();
        System.out.println("Введите текст (английский) (пустая строка для окончания):");

        String line;
        while ((line = scanner.nextLine()).length() > 0) {
            textBuilder.append(line).append('\n');
        }

        return textBuilder.toString();
    }
}
