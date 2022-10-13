package practice11;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Exercise5 {
    public static void main(String[] args) {
        var random = new Random();

        System.out.println("* testing ArrayList");
        testList(ArrayList::new, 1000, i -> random.nextInt());

        System.out.println("* testing LinkedList");
        testList(LinkedList::new, 1000, i -> random.nextInt());
    }

    private static <T> void testList(Supplier<List<T>> createList, int numberOfItems, Function<Integer, T> createItem) {
        List<T> list = createList.get();
        long[] measures = new long[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            var iWrapped = Integer.valueOf(i);
            measures[i] = measureTimeInNanoseconds(() -> list.add(iWrapped, createItem.apply(iWrapped)));
        }

        System.out.println("average timings (" + numberOfItems + " items):");
        System.out.println("add: " + Arrays.stream(measures).average().orElse(0) + "ns");

        for (int i = 0; i < numberOfItems; i++) {
            var iCopy = i;
            measures[i] = measureTimeInNanoseconds(() -> list.indexOf(list.get(iCopy)));
        }

        System.out.println("indexOf: " + Arrays.stream(measures).average().orElse(0) + "ns");

        for (int i = numberOfItems - 1; i >= 0; i--) {
            var iCopy = i;
            measures[i] = measureTimeInNanoseconds(() -> list.remove(iCopy));
        }

        System.out.println("remove: " + Arrays.stream(measures).average().orElse(0) + "ns");
    }

    private static long measureTimeInNanoseconds(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
