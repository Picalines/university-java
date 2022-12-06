package practice27.exercise1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        var hashSet = new HashSet<>();

        var random = new Random();
        for (int i = 0; i < 10; i++) {
            hashSet.add(random.nextInt(100));
        }

        printSet(hashSet);

        var treeSet = new TreeSet<>(hashSet);
        printSet(treeSet);
    }

    private static void printSet(Set<?> set) {
        System.out.print(set.getClass().getName() + " { ");
        for (var element : set) {
            System.out.print(element + " ");
        }
        System.out.println("}");
    }
}
