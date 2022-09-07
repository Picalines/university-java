package practice6;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    private final static Comparator<Student> comparatorInstance = new SortingStudentsByGPA();

    private SortingStudentsByGPA() {}

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getGpa(), s2.getGpa()) * -1;
    }

    public static void sort(Student[] students) {
        QuickSort.sort(students, comparatorInstance);
    }
}
