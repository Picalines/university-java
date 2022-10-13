package practice10;

import java.util.Comparator;

public class InsertionSort {
    private InsertionSort() {}

    public static <T> void sort(T[] items, Comparator<T> comparator) {
        for (int i = 1; i < items.length; i++) {
            T key = items[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(items[j], key) > 0) {
                items[j + 1] = items[j];
                j -= 1;
            }

            items[j + 1] = key;
        }
    }
}
