import java.util.List;

public class Department {
    String name;
    List<Employee> employees;
    double avgSalary;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
        this.avgSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAvgSalary() {
        return avgSalary;
    }
}
