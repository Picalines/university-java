package practice17.exercise2;

public class EmployeeView {
    public void printEmployeeDetails(Employee employee) {
        System.out.println("Employee details:");
        System.out.println("Name: " + employee.getName());
        System.out.println("Salary: " + employee.getSalary());
    }
}
