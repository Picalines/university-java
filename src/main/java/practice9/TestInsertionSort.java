package practice9;

import java.util.Comparator;

public class TestInsertionSort {
    public static void main(String[] args) {
        var students = new Student[]{
                new Student("Max", 10, 5),
                new Student("John", 1, 5),
                new Student("Peter", 5, 5)
        };

        System.out.println("initial: ");
        printArray(students);

        InsertionSort.sort(students, Comparator.comparingInt(Student::id));

        System.out.println("sorted: ");
        printArray(students);
    }

    public static <T> void printArray(T[] array) {
        for (var item : array) {
            System.out.println(item);
        }
    }
}
