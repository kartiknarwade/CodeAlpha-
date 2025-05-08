import java.util.*;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
            System.out.println("Employee with ID " + id + " removed.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void displayEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        while (true) {
            System.out.println("\nPayroll Menu:");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String ftName = sc.nextLine();
                    System.out.print("Enter ID: ");
                    int ftId = sc.nextInt();
                    System.out.print("Enter monthly salary: ");
                    double ftSalary = sc.nextDouble();
                    payrollSystem.addEmployee(new FullTimeEmployee(ftName, ftId, ftSalary));
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String ptName = sc.nextLine();
                    System.out.print("Enter ID: ");
                    int ptId = sc.nextInt();
                    System.out.print("Enter hours worked: ");
                    int hours = sc.nextInt();
                    System.out.print("Enter hourly rate: ");
                    double rate = sc.nextDouble();
                    payrollSystem.addEmployee(new PartTimeEmployee(ptName, ptId, hours, rate));
                    break;

                case 3:
                    System.out.print("Enter ID of employee to remove: ");
                    int removeId = sc.nextInt();
                    payrollSystem.removeEmployee(removeId);
                    break;

                case 4:
                    System.out.println("Employee Details:");
                    payrollSystem.displayEmployees();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
