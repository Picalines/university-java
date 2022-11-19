package practice17.exercise2;

public class EmployeeController {
    private final Employee model;
    private final EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void setEmployeeName(String name) {
        model.setName(name);
    }

    public String getEmployeeName() {
        return model.getName();
    }

    public double getEmployeeSalary() {
        return model.getSalary();
    }

    public void setEmployeeSalary(double newSalary) {
        model.setSalary(newSalary);
    }

    public void updateView() {
        view.printEmployeeDetails(model);
    }
}
