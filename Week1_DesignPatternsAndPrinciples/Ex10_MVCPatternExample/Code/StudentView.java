package Week1_DesignPatternsAndPrinciples.Ex10_MVCPatternExample.Code;
public class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("\nStudent Details:");
        System.out.println("Name : " + name);
        System.out.println("ID   : " + id);
        System.out.println("Grade: " + grade);
    }
}

