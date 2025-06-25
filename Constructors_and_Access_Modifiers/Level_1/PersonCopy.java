import java.util.*;

// Class to represent a Person
class Person 
{
    String name;
    int age;

    // Parameterized constructor to initialize name and age
    Person(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }

    // Copy constructor to create a new object by copying another object's data
    Person(Person other) 
    {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display the person's details
    void display() 
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Main class to test the Person class
public class PersonCopy 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        // Input for original person
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        // Creating the original Person object
        Person p1 = new Person(name, age);

        // Creating a copy of p1 using the copy constructor
        Person p2 = new Person(p1);

        // Display original person's details
        System.out.println("\nOriginal Person:");
        p1.display();

        // Display copied person's details
        System.out.println("\nCopied Person:");
        p2.display();
    }
}
