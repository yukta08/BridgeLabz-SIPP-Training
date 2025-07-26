import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        // Higher severity means higher priority
        return Integer.compare(other.severity, this.severity);
    }
}

public class Hospital_Triage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();

            System.out.print("Enter severity (1-10): ");
            int severity = sc.nextInt();
            sc.nextLine(); // Consume newline

            triageQueue.add(new Patient(name, severity));
        }

        System.out.println("\nTreatment Order (Most Severe First):");
        while (!triageQueue.isEmpty()) {
            Patient current = triageQueue.poll();
            System.out.println(current.name + " (Severity: " + current.severity + ")");
        }
    }
}
