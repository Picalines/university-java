package practice27.exercise2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var map = createMap();
        printMap(map);
        System.out.println("same first names: " + getSameFirstNameCount(map));
        System.out.println("same last name: " + getSameLastNameCount(map));
    }

    // count same keys in a HashMap? what?
    private static long getSameFirstNameCount(Map<String, String> map) {
        var firstNames = new HashSet<String>();
        return map.values().stream()
            .filter(firstName -> !firstNames.add(firstName))
            .count();
    }

    private static long getSameLastNameCount(Map<String, String> map) {
        var lastNames = new HashSet<String>();
        return map.keySet().stream()
            .filter(firstName -> !lastNames.add(firstName))
            .count();
    }

    private static Map<String, String> createMap() {
        var studentFirstNames = new String[]{
            "Oleg", "Max", "Petr",
        };

        var studentLastNames = new String[]{
            "Johnson", "Smith", "Jones",
        };

        var hashMap = new HashMap<String, String>();

        var random = new Random();
        for (int i = 0; i < 10; i++) {
            hashMap.put(
                studentLastNames[random.nextInt(studentLastNames.length)],
                studentFirstNames[random.nextInt(studentFirstNames.length)]);
        }

        return hashMap;
    }

    private static void printMap(Map<?, ?> map) {
        System.out.println("{");
        for (var entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + " => " + entry.getValue());
        }
        System.out.println("}");
    }
}
