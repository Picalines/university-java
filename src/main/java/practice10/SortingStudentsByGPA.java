package practice10;

import java.util.Comparator;

public class SortingStudentsByGPA {
    private Student[] iDNumber;
    private final Comparator<Student> gpaComparator;

    public SortingStudentsByGPA() {
        gpaComparator = Comparator.comparingDouble(Student::gpa).reversed();
    }

    public void setArray(Student[] students) {
        iDNumber = students;
    }

    public Student[] outArray() {
        return iDNumber;
    }

    public void quickSort(Comparator<Student> comparator) {
        QuickSort.sort(iDNumber, comparator);
    }

    public void mergeSort(Comparator<Student> comparator) {
        MergeSort.sort(iDNumber, comparator);
    }

    public void quickSort() {
        quickSort(gpaComparator);
    }

    public void mergeSort() {
        mergeSort(gpaComparator);
    }
}
