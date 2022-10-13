package practice9;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    private MergeSort() {}

    public static <T> void sort(T[] items, Comparator<T> comparator) {
        sort(items, comparator, 0, items.length - 1);
    }

    public static <T> T[] merge(T[] items1, T[] items2, Comparator<T> comparator) {
        T[] merged = Arrays.copyOf(items1, items1.length + items2.length);

        sort(items1 = Arrays.copyOf(items1, items1.length), comparator);
        sort(items2 = Arrays.copyOf(items2, items2.length), comparator);
        merge(merged, 0, items1, items2, comparator);

        return merged;
    }

    private static <T> void sort(T[] items, Comparator<T> comparator, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(items, comparator, low, mid);
        sort(items, comparator, mid + 1, high);
        merge(items, comparator, low, mid, high);
    }

    private static <T> void merge(T[] items, Comparator<T> comparator, int low, int mid, int high) {
        final T[] left = Arrays.copyOfRange(items, low, mid + 1);
        final T[] right = Arrays.copyOfRange(items, mid + 1, high + 1);

        merge(items, low, left, right, comparator);
    }

    private static <T> void merge(T[] items, int dest, T[] left, T[] right, Comparator<T> comparator) {
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            items[dest++] = comparator.compare(left[leftIndex], right[rightIndex]) < 0
                    ? left[leftIndex++]
                    : right[rightIndex++];
        }

        while (leftIndex < left.length) {
            items[dest++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            items[dest++] = right[rightIndex++];
        }
    }
}
