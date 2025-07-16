import java.util.ArrayList;
import java.util.Scanner;

// Abstract base class representing a general patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;

    // Constructor to initialize patient attributes
    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Getter methods for encapsulated fields
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }

    // Method to display patient details and total bill
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Total Bill: " + calculateBill());
    }

    // Abstract method to be implemented by specific patient types
    public abstract double calculateBill();
}

// Interface representing medical record functionality
interface MedicalRecord {
    void addRecord(String record);     // Add medical record entry
    void viewRecords();                // Display all medical records
}

// Class representing in-patients (admitted)
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double roomRate;
    private ArrayList<String> records = new ArrayList<>();

    // Constructor for in-patient with extra fields
    public InPatient(int id, String name, int age, String diagnosis, int days, double rate) {
        super(id, name, age, diagnosis);
        this.daysAdmitted = days;
        this.roomRate = rate;
    }

    // Calculate total bill as days * room rate
    public double calculateBill() {
        return daysAdmitted * roomRate;
    }

    // Add a medical record entry
    public void addRecord(String record) {
        records.add(record);
    }

    // Display all medical records
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String rec : records) System.out.println("- " + rec);
    }
}

// Class representing out-patients (consultation only)
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private ArrayList<String> records = new ArrayList<>();

    // Constructor for out-patient with consultation fee
    public OutPatient(int id, String name, int age, String diagnosis, double fee) {
        super(id, name, age, diagnosis);
        this.consultationFee = fee;
    }

    // Bill is just the consultation fee
    public double calculateBill() {
        return consultationFee;
    }

    // Add a medical record entry
    public void addRecord(String record) {
        records.add(record);
    }

    // Display all medical records
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String rec : records) System.out.println("- " + rec);
    }
}

// Main class to test the hospital-patient management system
public class Hospital_Patient_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Patient[] patients = new Patient[2];  // Fixed array to hold 2 patients

        // --- Input for In-Patient ---
        System.out.print("Enter In-Patient ID: ");
        int ipId = sc.nextInt();
        sc.nextLine();  // Consume newline

        System.out.print("Name: ");
        String ipName = sc.nextLine();

        System.out.print("Age: ");
        int ipAge = sc.nextInt();
        sc.nextLine();

        System.out.print("Diagnosis: ");
        String ipDiag = sc.nextLine();

        System.out.print("Days Admitted: ");
        int days = sc.nextInt();

        System.out.print("Room Rate: ");
        double rate = sc.nextDouble();
        sc.nextLine();

        // Create in-patient object and add records
        InPatient ip = new InPatient(ipId, ipName, ipAge, ipDiag, days, rate);
        ip.addRecord("Initial checkup done");
        ip.addRecord("MRI scheduled");
        patients[0] = ip;

        // --- Input for Out-Patient ---
        System.out.print("\nEnter Out-Patient ID: ");
        int opId = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String opName = sc.nextLine();

        System.out.print("Age: ");
        int opAge = sc.nextInt();
        sc.nextLine();

        System.out.print("Diagnosis: ");
        String opDiag = sc.nextLine();

        System.out.print("Consultation Fee: ");
        double fee = sc.nextDouble();
        sc.nextLine();

        // Create out-patient object and add record
        OutPatient op = new OutPatient(opId, opName, opAge, opDiag, fee);
        op.addRecord("X-ray advised");
        patients[1] = op;

        // --- Display patient details and records ---
        for (Patient p : patients) {
            p.getPatientDetails();  // Common patient info and bill
            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();  // Show medical records
            }
            System.out.println();  // Line break between patients
        }
    }
}
