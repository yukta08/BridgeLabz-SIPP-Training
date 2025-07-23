import java.util.*;

// ===== Abstract Course Type =====
abstract class CourseType 
{
    private String title;
    private int credit;

    public CourseType(String title, int credit) 
    {
        this.title = title;
        this.credit = credit;
    }

    public String getTitle() 
    {
        return title;
    }

    public int getCredit() 
    {
        return credit;
    }

    public abstract String getEvaluationMethod();

    public void displayCourse() 
    {
        System.out.println("[" + getEvaluationMethod() + "] " + title + " (" + credit + " credits)");
    }
}

// ===== Concrete Course Types =====
class ExamCourse extends CourseType 
{
    public ExamCourse(String title, int credit) 
    {
        super(title, credit);
    }

    public String getEvaluationMethod() 
    {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType 
{
    public AssignmentCourse(String title, int credit) 
    {
        super(title, credit);
    }

    public String getEvaluationMethod() 
    {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType 
{
    public ResearchCourse(String title, int credit) 
    {
        super(title, credit);
    }

    public String getEvaluationMethod() 
    {
        return "Research-Based";
    }
}

// ===== Generic Course Class with Bounded Type =====
class Course<T extends CourseType> 
{
    private List<T> courseList;

    public Course() 
    {
        courseList = new ArrayList<>();
    }

    public void addCourse(T course) 
    {
        courseList.add(course);
    }

    public List<T> getAllCourses() 
    {
        return courseList;
    }
}

// ===== Utility Class with Wildcard Display =====
class University_Utility 
{
    public static void displayCourses(List<? extends CourseType> courseList) 
    {
        if (courseList.isEmpty()) 
        {
            System.out.println("No courses available.");
            return;
        }

        for (CourseType course : courseList) 
        {
            course.displayCourse();
        }
    }
}

// ===== Main Class =====
public class University_Course_System 
{
    public static void main(String[] args) 
    {
        // Department Course Lists
        Course<ExamCourse> csDepartment = new Course<>();
        Course<AssignmentCourse> commerceDepartment = new Course<>();
        Course<ResearchCourse> scienceDepartment = new Course<>();

        // Add courses
        csDepartment.addCourse(new ExamCourse("Data Structures", 4));
        csDepartment.addCourse(new ExamCourse("Operating Systems", 3));

        commerceDepartment.addCourse(new AssignmentCourse("Accounting", 3));
        commerceDepartment.addCourse(new AssignmentCourse("Marketing", 2));

        scienceDepartment.addCourse(new ResearchCourse("Quantum Mechanics", 4));
        scienceDepartment.addCourse(new ResearchCourse("Advanced Genetics", 3));

        // Display Courses
        System.out.println("=== CS Department ===");
        University_Utility.displayCourses(csDepartment.getAllCourses());

        System.out.println("\n=== Commerce Department ===");
        University_Utility.displayCourses(commerceDepartment.getAllCourses());

        System.out.println("\n=== Science Department ===");
        University_Utility.displayCourses(scienceDepartment.getAllCourses());
    }
}
