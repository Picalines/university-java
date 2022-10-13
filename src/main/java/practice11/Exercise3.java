package practice11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

record Student(String name, int id, double gpa, Date birthDate) {
    public String toString(String birthDateFormat) {
        var formatted = new SimpleDateFormat(birthDateFormat).format(birthDate);
        return "Student(name: " + name + ", id: " + id + ", gpa: " + gpa + ", birthDate: " + formatted + ")";
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 29);
        calendar.set(Calendar.MONTH, Calendar.SEPTEMBER);
        calendar.set(Calendar.YEAR, 2003);
        var student = new Student("Me", 13, -1, calendar.getTime());
        System.out.println(student.toString("dd.mm.yyyy"));
    }
}
