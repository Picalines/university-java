package practice9;

import java.util.Comparator;

public class QuickSort {
    private QuickSort() {}

    public static <T> void sort(T[] items, Comparator<T> comparator) {
        sort(items, comparator, 0, items.length - 1);
    }

    private static <T> void sort(T[] items, Comparator<T> comparator, int low, int high) {
        if (low >= high) {
            return;
        }

        int partitionIndex = sortPartition(items, comparator, low, high);
        sort(items, comparator, low, partitionIndex - 1);
        sort(items, comparator, partitionIndex + 1, high);
    }

    private static <T> int sortPartition(T[] items, Comparator<T> comparator, int low, int high) {
        T pivot = items[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (comparator.compare(items[j], pivot) < 0) {
                i++;
                arraySwap(items, i, j);
            }
        }

        arraySwap(items, i + 1, high);
        return i + 1;
    }

    private static <T> void arraySwap(T[] items, int index1, int index2) {
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
}
