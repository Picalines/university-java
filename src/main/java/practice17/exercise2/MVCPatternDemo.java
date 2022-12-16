package practice17.exercise2;

public class MVCPatternDemo {
    public static void main(String[] args) {
        var model = retrieveEmployeeFromDatabase();
        var view = new EmployeeView();

        var controller = new EmployeeController(model, view);

        controller.updateView();

        controller.setEmployeeName("Vlad");
        System.out.println("(student updated)");

        controller.updateView();
    }

    private static Employee retrieveEmployeeFromDatabase() {
        return new Employee("Max", 1000);
    }
}
