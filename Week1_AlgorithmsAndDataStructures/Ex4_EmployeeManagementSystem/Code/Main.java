package Week1_AlgorithmsAndDataStructures.Ex4_EmployeeManagementSystem.Code;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E101", "Alice", "Manager", 75000));
        manager.addEmployee(new Employee("E102", "Bob", "Engineer", 60000));
        manager.addEmployee(new Employee("E103", "Carol", "Analyst", 50000));

        System.out.println("\nAll Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearch Employee E102:");
        System.out.println(manager.searchEmployee("E102"));

        System.out.println("\nDeleting Employee E102...");
        manager.deleteEmployee("E102");

        System.out.println("\nAll Employees After Deletion:");
        manager.traverseEmployees();
    }
}

