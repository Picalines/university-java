package practice20.exercise4;

import java.util.Arrays;
import java.util.Comparator;

public class MinMax<T extends Comparable<T>> {
    private final T[] array;

    public MinMax(T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array");
        }

        this.array = array;
    }

    public T min() {
        return Arrays.stream(array).min(Comparator.naturalOrder()).orElseThrow();
    }

    public T max() {
        return Arrays.stream(array).max(Comparator.naturalOrder()).orElseThrow();
    }

    public static void main(String[] args) {
        var minMax = new MinMax<>(new Integer[] { 4, 10, -1 });
        System.out.println(minMax.min());
        System.out.println(minMax.max());
    }
}
