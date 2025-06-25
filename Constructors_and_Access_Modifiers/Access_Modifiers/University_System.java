// Superclass to represent a general student
class Student 
{
    public int rollNumber;       // Public variable can be accessed anywhere
    protected String name;       // Protected variable accessible within same package and subclass
    private double cgpa;         // Private variable accessible only within this class

    // Constructor to initialize roll number and name
    Student(int rollNumber, String name) 
    {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    // Public method to set the CGPA (write access to private variable)
    public void setCGPA(double cgpa) 
    {
        this.cgpa = cgpa;
    }

    // Public method to get the CGPA (read access to private variable)
    public double getCGPA() 
    {
        return cgpa;
    }

    // Method to display basic student details
    public void displayStudent() 
    {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}

// Subclass to represent a postgraduate student
class PostgraduateStudent extends Student 
{
    String specialization;   // Additional attribute specific to postgraduate students

    // Constructor using super to initialize inherited members
    PostgraduateStudent(int rollNumber, String name, String specialization) 
    {
        super(rollNumber, name);
        this.specialization = specialization;
    }

    // Method to display postgraduate student details including protected member
    public void displayPostgraduate() 
    {
        System.out.println("Roll Number: " + rollNumber);  // public from Student
        System.out.println("Name: " + name);               // protected from Student
        System.out.println("Specialization: " + specialization);
    }
}

// Main class to run the program
public class University_System 
{
    public static void main(String[] args) 
    {
        // Creating an instance of Student
        Student s1 = new Student(101, "Amit");
        s1.setCGPA(8.9);
        System.out.println("--- Student Details ---");
        s1.displayStudent();

        System.out.println();

        // Creating an instance of PostgraduateStudent
        PostgraduateStudent pg = new PostgraduateStudent(102, "Riya", "Computer Science");
        pg.setCGPA(9.3);
        System.out.println("--- Postgraduate Student Details ---");
        pg.displayPostgraduate();
        System.out.println("CGPA: " + pg.getCGPA());  // Accessing private member via public method
    }
}
