import java.util.*;

// Class to represent an online course
class Course 
{
    String courseName;      // Instance variable for course name
    int duration;           // Instance variable for duration in weeks or months
    double fee;             // Instance variable for course fee

    static String instituteName = "Default Institute"; // Class variable shared by all courses

    // Constructor to initialize course details
    Course(String courseName, int duration, double fee) 
    {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() 
    {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
    }

    // Class method to update the institute name
    static void updateInstituteName(String name) 
    {
        instituteName = name;
    }
}

// Main class to run the Course Management System
public class Online_Course_Manager 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Update the institute name using class method
        System.out.print("Enter Institute Name: ");
        String newInstitute = sc.nextLine();
        Course.updateInstituteName(newInstitute);

        // Create first course
        System.out.print("Enter Course 1 Name: ");
        String course1 = sc.nextLine();
        System.out.print("Enter Duration (in weeks): ");
        int dur1 = sc.nextInt();
        System.out.print("Enter Fee: ");
        double fee1 = sc.nextDouble();
        sc.nextLine(); // clear buffer
        Course c1 = new Course(course1, dur1, fee1);

        // Create second course
        System.out.print("Enter Course 2 Name: ");
        String course2 = sc.nextLine();
        System.out.print("Enter Duration (in weeks): ");
        int dur2 = sc.nextInt();
        System.out.print("Enter Fee: ");
        double fee2 = sc.nextDouble();
        Course c2 = new Course(course2, dur2, fee2);

        // Display course details
        System.out.println("\n--- Course 1 Details ---");
        c1.displayCourseDetails();

        System.out.println("\n--- Course 2 Details ---");
        c2.displayCourseDetails();
    }
}
