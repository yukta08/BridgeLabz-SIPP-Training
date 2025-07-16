import java.util.Scanner;

// Abstract base class for all types of employees
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor to initialize employee data
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getter methods for accessing private fields
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    // Method to display employee details
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

// Interface to represent department behavior
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Full-time employee class extending Employee and implementing Department
class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double bonus;

    // Constructor to initialize full-time employee
    public FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    // Implementation of abstract method to calculate salary with bonus
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    // Assign a department to employee
    public void assignDepartment(String deptName) {
        department = deptName;
    }

    // Return department details
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Part-time employee class extending Employee and implementing Department
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;

    // Constructor to initialize part-time employee
    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, 0);  // baseSalary not used directly
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Calculate salary based on hourly rate and hours worked
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    // Assign a department to employee
    public void assignDepartment(String deptName) {
        department = deptName;
    }

    // Return department details
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Main class to run the Employee Management System
public class Employee_Management_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array to hold employees
        Employee[] employees = new Employee[2];

        // Input and creation of Full-Time Employee
        System.out.print("Enter Full-Time Employee ID: ");
        int id1 = sc.nextInt();
        sc.nextLine();  // consume leftover newline
        System.out.print("Enter Name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Base Salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter Bonus: ");
        double bonus = sc.nextDouble();
        sc.nextLine();  // consume leftover newline
        System.out.print("Enter Department: ");
        String dept1 = sc.nextLine();

        FullTimeEmployee ft = new FullTimeEmployee(id1, name1, salary, bonus);
        ft.assignDepartment(dept1);  // assign department to full-time employee

        // Input and creation of Part-Time Employee
        System.out.print("\nEnter Part-Time Employee ID: ");
        int id2 = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Enter Name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Hourly Rate: ");
        double rate = sc.nextDouble();
        System.out.print("Enter Hours Worked: ");
        int hours = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Enter Department: ");
        String dept2 = sc.nextLine();

        PartTimeEmployee pt = new PartTimeEmployee(id2, name2, rate, hours);
        pt.assignDepartment(dept2);  // assign department to part-time employee

        // Store both employees in the array
        employees[0] = ft;
        employees[1] = pt;

        // Display all employee details
        for (Employee e : employees) {
            e.displayDetails();
            if (e instanceof Department) {
                // Downcast to access department methods
                System.out.println(((Department) e).getDepartmentDetails());
            }
            System.out.println();
        }
    }
}
