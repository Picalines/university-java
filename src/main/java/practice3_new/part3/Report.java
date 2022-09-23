package practice3_new.part3;

public class Report {
    public static void generateReport(Employee[] employees) {
        for (var employee : employees) {
            System.out.print(employee.getFullName() + "'s salary: ");
            System.out.printf("%10.2f", employee.getSalary());
            System.out.println();
        }
    }
}
