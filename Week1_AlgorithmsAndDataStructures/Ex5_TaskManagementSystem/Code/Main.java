package Week1_AlgorithmsAndDataStructures.Ex5_TaskManagementSystem.Code;

public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        // Adding Tasks
        taskList.addTask(new Task("T101", "Setup Project", "Pending"));
        taskList.addTask(new Task("T102", "Develop Features", "In-Progress"));
        taskList.addTask(new Task("T103", "Test Application", "Completed"));

        // Traverse Tasks
        System.out.println("\nAll Tasks:");
        taskList.traverseTasks();

        // Search for a Task
        System.out.println("\nSearch for Task T102:");
        System.out.println(taskList.searchTask("T102"));

        // Delete a Task
        System.out.println("\nDeleting Task T102...");
        taskList.deleteTask("T102");

        // Traverse After Deletion
        System.out.println("\nAll Tasks After Deletion:");
        taskList.traverseTasks();
    }
}

