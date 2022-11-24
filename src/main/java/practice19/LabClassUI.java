package practice19;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

record Student(String name, double GPA) {}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String studentName) {
        super("student with name '" + studentName + "' was not found");
    }
}

public class LabClassUI extends JFrame {
    private LabClassUI() {
        super("Students sorter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 600);

        setLayout(new BorderLayout());

        var northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));
        add(northPanel, BorderLayout.NORTH);

        var searchField = new JTextField();
        northPanel.add(searchField);

        var messageLabel = new JLabel();
        northPanel.add(messageLabel);

        var studentsArray = generateStudentsArray(100);
        InsertionSort.sort(studentsArray, Comparator.comparingDouble(Student::GPA));

        var studentsJList = new JList<>();
        studentsJList.setListData(studentsArray);

        searchField.addActionListener(l -> {
            messageLabel.setText("");
            studentsJList.setListData(new Student[]{});

            try {
                var studentNameToSearch = searchField.getText();

                var matchingStudents = studentNameToSearch.length() == 0
                    ? studentsArray
                    : Arrays.stream(studentsArray)
                    .filter(student -> student.name().contains(studentNameToSearch))
                    .toArray();

                if (matchingStudents.length == 0) {
                    throw new StudentNotFoundException(studentNameToSearch);
                }

                studentsJList.setListData(matchingStudents);
            } catch (Exception exception) {
                messageLabel.setText(exception.getClass().getName() + ": " + exception.getMessage());
            }
        });

        add(new JScrollPane(studentsJList), BorderLayout.CENTER);

        setVisible(true);
    }

    private static Student[] generateStudentsArray(int numberOfStudents) {
        var studentFirstNames = new String[]{
            "Oleg", "Max", "Petr", "Dmitri", "Olga", "Masha", "Kate",
        };

        var studentLastNames = new String[]{
            "Johnson", "Smith", "Jones", "Williams", "Brown",
        };

        var array = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            var randomFirstName = studentFirstNames[(int) Math.floor(Math.random() * studentFirstNames.length)];
            var randomLastName = studentLastNames[(int) Math.floor(Math.random() * studentLastNames.length)];
            array[i] = new Student(randomFirstName + " " + randomLastName, Math.random() * 5);
        }

        return array;
    }

    public static void main(String[] args) {
        new LabClassUI();
    }
}
