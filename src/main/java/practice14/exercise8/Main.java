package practice14.exercise8;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        printlnArray(filter(new Object[] { 1, 2, 3, 4, 5 }, element -> (int)element % 2 != 0));
        printlnArray(filter(new Object[] { "a", "abc", "cde" }, element -> ((String)element).contains("c")));
    }

    private static Object[] filter(Object[] array, Predicate<Object> keepElement) {
        var keptElements = new ArrayList<>();

        for (var element : array) {
            if (keepElement.test(element)) {
                keptElements.add(element);
            }
        }

        return keptElements.toArray();
    }

    private static void printlnArray(Object[] array) {
        if (array.length == 0) {
            System.out.println("[]");
            return;
        }

        if (array.length == 1) {
            System.out.println("[" + array[0] + "]");
            return;
        }

        System.out.print('[');
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i]);
            System.out.print(", ");
        }

        System.out.print(array[array.length - 1]);
        System.out.println(']');
    }
}
