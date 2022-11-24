package practice19;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

record Student(String name, double GPA) {}

public class LabClassUI extends JFrame {
    private LabClassUI() {
        super("Students sorter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 600);

        setLayout(new BorderLayout());

        var searchField = new JTextField();
        add(searchField, BorderLayout.NORTH);

        var listModel = new DefaultListModel<Student>();
        listModel.addAll(generateStudentsArray(100));

        var list = new JList<>(listModel);
        add(new JScrollPane(list), BorderLayout.CENTER);

        setVisible(true);
    }

    private static ArrayList<Student> generateStudentsArray(int numberOfStudents) {
        var studentFirstNames = new String[] {
            "Oleg", "Max", "Petr", "Dmitri", "Olga", "Masha", "Kate",
        };

        var studentLastNames = new String[] {
            "Johnson", "Smith", "Jones", "Williams", "Brown",
        };

        var list = new ArrayList<Student>();
        for (int i = 0; i < numberOfStudents; i++) {
            var randomFirstName = studentFirstNames[(int)Math.floor(Math.random() * studentFirstNames.length)];
            var randomLastName = studentLastNames[(int)Math.floor(Math.random() * studentLastNames.length)];
            list.add(new Student(randomFirstName + " " + randomLastName, Math.random() * 5));
        }
        return list;
    }

    public static void main(String[] args) {
        new LabClassUI();
    }
}
