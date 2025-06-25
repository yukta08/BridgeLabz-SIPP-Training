import java.util.*;

// Class representing a Student
class Student 
{
    String name;           // Student's name
    int rollNumber;        // Student's roll number
    double marks;          // Marks obtained by the student

    // Method to take user input
    void input(Scanner sc) 
    {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        rollNumber = sc.nextInt();
        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
    }

    // Method to calculate grade based on marks
    String getGrade() 
    {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 60) return "C";
        if (marks >= 40) return "D";
        return "F"; // Failed
    }

    // Method to display student details and grade
    void display() 
    {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + getGrade());
    }
}

// Main class to simulate student report
public class StudentReport 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);     // Create Scanner object
        Student student = new Student();         // Create Student object
        student.input(sc);                       // Take student input
        student.display();                       // Display student details and grade
    }
}
