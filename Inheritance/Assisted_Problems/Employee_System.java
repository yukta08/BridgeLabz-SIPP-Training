import java.util.*;

// Base class Employee
class Employee {
    String name;
    int id;
    double salary;

    // Constructor to initialize employee details
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: ₹" + salary);
    }
}

// Subclass Manager
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass Developer
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass Intern
class Intern extends Employee {
    String college;

    Intern(String name, int id, double salary, String college) {
        super(name, id, salary);
        this.college = college;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("College: " + college);
    }
}

// Main class
public class Employee_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Manager input
        System.out.println("Enter Manager Details:");
        System.out.print("Name: ");
        String mName = sc.nextLine();
        System.out.print("ID: ");
        int mId = sc.nextInt();
        System.out.print("Salary: ");
        double mSalary = sc.nextDouble();
        System.out.print("Team Size: ");
        int mTeam = sc.nextInt();
        sc.nextLine();
        Manager manager = new Manager(mName, mId, mSalary, mTeam);

        // Developer input
        System.out.println("\nEnter Developer Details:");
        System.out.print("Name: ");
        String dName = sc.nextLine();
        System.out.print("ID: ");
        int dId = sc.nextInt();
        System.out.print("Salary: ");
        double dSalary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Programming Language: ");
        String lang = sc.nextLine();
        Developer developer = new Developer(dName, dId, dSalary, lang);

        // Intern input
        System.out.println("\nEnter Intern Details:");
        System.out.print("Name: ");
        String iName = sc.nextLine();
        System.out.print("ID: ");
        int iId = sc.nextInt();
        System.out.print("Salary: ");
        double iSalary = sc.nextDouble();
        sc.nextLine();
        System.out.print("College: ");
        String college = sc.nextLine();
        Intern intern = new Intern(iName, iId, iSalary, college);

        // Displaying all employee details
        System.out.println("\n--- Manager Info ---");
        manager.displayDetails();
        System.out.println("\n--- Developer Info ---");
        developer.displayDetails();
        System.out.println("\n--- Intern Info ---");
        intern.displayDetails();
    }
}
