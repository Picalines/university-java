package practice17.exercise1;

public class MVCPatternDemo {
    public static void main(String[] args) {
        var model = retrieveStudentFromDatabase();
        var view = new StudentView();

        var controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Vlad");
        System.out.println("(student updated)");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        return new Student("01", "Max");
    }
}
