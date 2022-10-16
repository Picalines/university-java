package practice13.exercise6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(getLine(new Scanner(System.in).nextLine()));
    }

    private static String getLine(String str) {
        var words = new HashSet<>(Arrays.asList(str.split("\\s+")));
        var builder = new StringBuilder();

        var lastWord = words.stream().findFirst().orElseThrow();
        words.remove(lastWord);
        builder.append(lastWord);

        while (!words.isEmpty()) {
            var lastWordChar = lastWord.charAt(lastWord.length() - 1);
            var nextWord = words.stream()
                .filter(w -> Character.toLowerCase(lastWordChar) == Character.toLowerCase(w.charAt(0)))
                .findFirst()
                .orElseThrow();

            builder.append(' ');
            builder.append(nextWord);

            words.remove(nextWord);
            lastWord = nextWord;
        }

        return builder.toString();
    }
}
