package Week1_AlgorithmsAndDataStructures.Ex4_EmployeeManagementSystem.Code;

public class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee \n" +
           "  employeeId='" + employeeId + "'\n" +
           "  name='" + name + "'\n" +
           "  position='" + position + "'\n" +
           "  salary=" + salary + '\n' 
;
    }
}

