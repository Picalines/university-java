package practice3_new.part3;

public class ReportTest {
    public static void main(String[] args) {
        var employees = new Employee[] {
            new Employee("John A", 100.5),
            new Employee("John B", 55.23),
            new Employee("John C", 99.1),
        };

        Report.generateReport(employees);
    }
}
