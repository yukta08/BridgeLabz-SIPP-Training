import java.util.*;

// Superclass representing a generic person
class Person 
{
    String name;
    int id;

    // Constructor to initialize name and id
    Person(String name, int id) 
    {
        this.name = name;
        this.id = id;
    }

    // Method to display person details
    void showDetails() 
    {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface representing a Worker with duties
interface Worker 
{
    void performDuties();  // Abstract method to be implemented
}

// Subclass Chef that inherits Person and implements Worker
class Chef extends Person implements Worker 
{
    String specialty;

    // Constructor to initialize Chef-specific details
    Chef(String name, int id, String specialty) 
    {
        super(name, id);
        this.specialty = specialty;
    }

    // Method from Worker interface
    public void performDuties() 
    {
        System.out.println("Chef is cooking: " + specialty);
    }
}

// Subclass Waiter that inherits Person and implements Worker
class Waiter extends Person implements Worker 
{
    int tableCount;

    // Constructor to initialize Waiter-specific details
    Waiter(String name, int id, int tableCount) 
    {
        super(name, id);
        this.tableCount = tableCount;
    }

    // Method from Worker interface
    public void performDuties() 
    {
        System.out.println("Waiter is serving " + tableCount + " tables.");
    }
}

// Main class to run the Restaurant Management System
public class Restaurant_System 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose role: 1 for Chef, 2 for Waiter");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        Worker worker = null;

        if (choice == 1) 
        {
            System.out.print("Enter Specialty: ");
            String specialty = sc.nextLine();
            worker = new Chef(name, id, specialty);
        } 
        else if (choice == 2) 
        {
            System.out.print("Enter Number of Tables: ");
            int tables = sc.nextInt();
            worker = new Waiter(name, id, tables);
        } 
        else 
        {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("\n--- Worker Details ---");
        ((Person) worker).showDetails();  // Cast to access Person method
        worker.performDuties();           // Interface method
    }
}
