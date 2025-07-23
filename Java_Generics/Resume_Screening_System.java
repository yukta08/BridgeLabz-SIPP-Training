import java.util.*;

// ===== Abstract Job Role =====
abstract class JobRole 
{
    private String candidateName;

    public JobRole(String candidateName) 
    {
        this.candidateName = candidateName;
    }

    public String getCandidateName() 
    {
        return candidateName;
    }

    public abstract String getRole();
    public abstract List<String> getKeySkills();

    public void displayResume() 
    {
        System.out.println("[" + getRole() + "] Resume: " + candidateName);
        System.out.println("Skills: " + String.join(", ", getKeySkills()));
    }
}

// ===== Concrete Job Roles =====
class SoftwareEngineer extends JobRole 
{
    public SoftwareEngineer(String candidateName) 
    {
        super(candidateName);
    }

    public String getRole() 
    {
        return "Software Engineer";
    }

    public List<String> getKeySkills() 
    {
        return Arrays.asList("Java", "Spring", "Microservices", "Git");
    }
}

class DataScientist extends JobRole 
{
    public DataScientist(String candidateName) 
    {
        super(candidateName);
    }

    public String getRole() 
    {
        return "Data Scientist";
    }

    public List<String> getKeySkills() 
    {
        return Arrays.asList("Python", "Machine Learning", "Pandas", "SQL");
    }
}

class ProductManager extends JobRole 
{
    public ProductManager(String candidateName) 
    {
        super(candidateName);
    }

    public String getRole() 
    {
        return "Product Manager";
    }

    public List<String> getKeySkills() 
    {
        return Arrays.asList("Agile", "Roadmapping", "Stakeholder Communication");
    }
}

// ===== Generic Resume Wrapper =====
class Resume<T extends JobRole> 
{
    private T role;

    public Resume(T role) 
    {
        this.role = role;
    }

    public T getRoleData() 
    {
        return role;
    }

    public void printResume() 
    {
        role.displayResume();
    }
}

// ===== Screening Utility Class =====
class ResumeScreening 
{
    public static <T extends JobRole> void screenResume(Resume<T> resume) 
    {
        System.out.println("Screening resume for: " + resume.getRoleData().getRole());
        resume.printResume();
        System.out.println();
    }

    public static void bulkScreen(List<? extends JobRole> candidates) 
    {
        if (candidates.isEmpty()) 
        {
            System.out.println("No resumes to screen.");
            return;
        }

        for (JobRole role : candidates) 
        {
            role.displayResume();
            System.out.println();
        }
    }
}

// ===== Main Program =====
public class Resume_Screening_System 
{
    public static void main(String[] args) 
    {
        Resume<SoftwareEngineer> r1 = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> r2 = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> r3 = new Resume<>(new ProductManager("Carol"));

        System.out.println("=== Individual Screening ===");
        ResumeScreening.screenResume(r1);
        ResumeScreening.screenResume(r2);
        ResumeScreening.screenResume(r3);

        System.out.println("=== Bulk Screening Pipeline ===");
        List<JobRole> resumeList = new ArrayList<>();
        resumeList.add(new SoftwareEngineer("Dave"));
        resumeList.add(new DataScientist("Eve"));
        resumeList.add(new ProductManager("Frank"));

        ResumeScreening.bulkScreen(resumeList);
    }
}
