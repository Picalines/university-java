package practice6;

import java.util.Comparator;

public class TestStudentGPASorting {
    public static void main(String[] args) {
        var students = new Student[]{
                new Student("Max", 10, 2),
                new Student("John", 1, 5),
                new Student("Peter", 5, 3)
        };

        System.out.println("initial: ");
        printArray(students);

        SortingStudentsByGPA.sort(students);

        System.out.println("sorted: ");
        printArray(students);
    }



    public static <T> void printArray(T[] array) {
        for (var item : array) {
            System.out.println(item);
        }
    }
}
