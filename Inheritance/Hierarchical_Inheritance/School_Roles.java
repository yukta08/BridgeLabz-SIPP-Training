import java.util.*;

// Superclass representing a general person in the school
class Person 
{
    String name;
    int age;

    // Constructor to initialize common person attributes
    Person(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }

    // Method to display basic person details
    void displayInfo() 
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass representing a teacher
class Teacher extends Person 
{
    String subject;

    // Constructor to initialize teacher attributes
    Teacher(String name, int age, String subject) 
    {
        super(name, age);
        this.subject = subject;
    }

    // Method to display teacher's role
    void displayRole() 
    {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Subclass representing a student
class Student extends Person 
{
    String grade;

    // Constructor to initialize student attributes
    Student(String name, int age, String grade) 
    {
        super(name, age);
        this.grade = grade;
    }

    // Method to display student's role
    void displayRole() 
    {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Subclass representing a staff member
class Staff extends Person 
{
    String department;

    // Constructor to initialize staff attributes
    Staff(String name, int age, String department) 
    {
        super(name, age);
        this.department = department;
    }

    // Method to display staff's role
    void displayRole() 
    {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Main class to test different roles in the school
public class School_Roles 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 for Teacher, 2 for Student, 3 for Staff:");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline

        Person person;

        switch (choice) 
        {
            case 1:
                System.out.print("Enter Subject: ");
                String subject = sc.nextLine();
                person = new Teacher(name, age, subject);
                break;
            case 2:
                System.out.print("Enter Grade: ");
                String grade = sc.nextLine();
                person = new Student(name, age, grade);
                break;
            case 3:
                System.out.print("Enter Department: ");
                String department = sc.nextLine();
                person = new Staff(name, age, department);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\n--- Person Details ---");
        person.displayInfo();

        if (person instanceof Teacher)
            ((Teacher) person).displayRole();
        else if (person instanceof Student)
            ((Student) person).displayRole();
        else if (person instanceof Staff)
            ((Staff) person).displayRole();
    }
}
