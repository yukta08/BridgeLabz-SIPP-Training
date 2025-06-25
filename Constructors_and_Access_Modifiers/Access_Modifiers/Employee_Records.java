// Class to represent an Employee with controlled access to its fields
class Employee 
{
    public String employeeID;       // Public: can be accessed from anywhere
    protected String department;    // Protected: accessible within subclass and same package
    private double salary;          // Private: only accessible within this class

    // Constructor to initialize employee details
    Employee(String employeeID, String department, double salary) 
    {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify the employee's salary
    public void setSalary(double salary) 
    {
        if (salary > 0) 
        {
            this.salary = salary;
        }
    }

    // Public method to get the employee's salary (read-only access)
    public double getSalary() 
    {
        return salary;
    }

    // Public method to display employee details
    public void displayEmployee() 
    {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + getSalary());
    }
}

// Subclass representing a Manager (inherits from Employee)
class Manager extends Employee 
{
    // Constructor to initialize Manager using parent class constructor
    Manager(String employeeID, String department, double salary) 
    {
        super(employeeID, department, salary);
    }

    // Method specific to Manager to display limited inherited details
    public void displayManagerInfo() 
    {
        System.out.println("Manager ID: " + employeeID);      // Accessing public field
        System.out.println("Department: " + department);      // Accessing protected field
    }
}

// Main class to test Employee and Manager functionality
public class Employee_Records 
{
    public static void main(String[] args) 
    {
        // Creating an Employee object
        Employee emp = new Employee("EMP123", "Finance", 40000.0);
        emp.setSalary(45000.0);
        System.out.println("--- Employee Details ---");
        emp.displayEmployee();

        System.out.println();

        // Creating a Manager object (inherits from Employee)
        Manager mgr = new Manager("MGR001", "HR", 60000.0);
        System.out.println("--- Manager Info ---");
        mgr.displayManagerInfo();
        System.out.println("Manager Salary: ₹" + mgr.getSalary());
    }
}
