import java.util.*;

// Base class representing a general course
class Course 
{
    String courseName;
    int duration; // in weeks

    // Constructor to initialize course details
    Course(String courseName, int duration) 
    {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course details
    void displayCourse() 
    {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass representing an online course
class OnlineCourse extends Course 
{
    String platform;
    boolean isRecorded;

    // Constructor to initialize online course details
    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) 
    {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Method to display online course details
    @Override
    void displayCourse() 
    {
        super.displayCourse();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded Lectures: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass representing a paid online course
class PaidOnlineCourse extends OnlineCourse 
{
    double fee;
    double discount;

    // Constructor to initialize paid course details
    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) 
    {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    // Method to calculate net payable fee
    double calculateNetFee() 
    {
        return fee - (fee * discount / 100);
    }

    // Method to display all course details
    @Override
    void displayCourse() 
    {
        super.displayCourse();
        System.out.println("Course Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Net Payable: ₹" + calculateNetFee());
    }
}

// Main class to test the multilevel inheritance
public class Course_Hierarchy 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Duration (in weeks): ");
        int duration = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Platform Name: ");
        String platform = sc.nextLine();

        System.out.print("Is it Recorded? (true/false): ");
        boolean recorded = sc.nextBoolean();

        System.out.print("Enter Course Fee: ");
        double fee = sc.nextDouble();

        System.out.print("Enter Discount (%): ");
        double discount = sc.nextDouble();

        // Create PaidOnlineCourse object
        PaidOnlineCourse poc = new PaidOnlineCourse(name, duration, platform, recorded, fee, discount);

        // Display course summary
        System.out.println("\n--- Course Details ---");
        poc.displayCourse();
    }
}
