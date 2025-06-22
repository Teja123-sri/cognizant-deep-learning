package Week1_AlgorithmsAndDataStructures.Ex5_TaskManagementSystem.Code;

public class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
         return "Task \n" +
           "  taskId='" + taskId + "'\n" +
           "  taskName='" + taskName + "'\n" +
           "  status='" + status + "'\n";
    }
}

