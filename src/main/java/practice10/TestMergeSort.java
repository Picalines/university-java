package practice10;

import java.util.Comparator;

public class TestMergeSort {
    public static void main(String[] args) {
        var students1 = new Student[]{
                new Student("Max", 10, 5),
                new Student("John", 1, 5),
                new Student("Peter", 5, 5)
        };

        var students2 = new Student[]{
                new Student("Oleg", 20, 5),
                new Student("Alexander", 7, 5),
                new Student("David", 2, 5)
        };

        System.out.println("first list:");
        printArray(students1);
        System.out.println("second list:");
        printArray(students2);

        var mergedStudents = MergeSort.merge(students1, students2, Comparator.comparingInt(Student::id));

        System.out.println("merged:");
        printArray(mergedStudents);
    }

    public static <T> void printArray(T[] array) {
        for (var item : array) {
            System.out.println(item);
        }
    }
}
