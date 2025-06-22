package Week1_DesignPatternsAndPrinciples.Ex10_MVCPatternExample.Code;

public class Main {
    public static void main(String[] args) {
        // Model
        Student student = new Student("John Doe", "S101", "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        System.out.println("Initial Student Details:");
        controller.updateView();

        System.out.println("\nUpdating Student Details...");
        controller.setStudentName("steve");
        controller.setStudentId("AQ908");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}

