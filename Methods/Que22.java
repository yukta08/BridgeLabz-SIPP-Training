import java.util.Scanner;

public class Que22 {

    // Method to calculate BMI
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Method to determine BMI status
    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numberOfMembers = 10;
        double[] weights = new double[numberOfMembers];
        double[] heights = new double[numberOfMembers];
        double[] bmis = new double[numberOfMembers];
        String[] statuses = new String[numberOfMembers];

        // Input weights and heights
        for (int i = 0; i < numberOfMembers; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1) + ":");
            weights[i] = scanner.nextDouble();

            System.out.println("Enter height (cm) for person " + (i + 1) + ":");
            heights[i] = scanner.nextDouble() / 100; // convert cm to meters

            bmis[i] = calculateBMI(weights[i], heights[i]);
            statuses[i] = getBMIStatus(bmis[i]);
        }

        // Display results
        System.out.println("\nBMI Results:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Person", "Weight(kg)", "Height(m)", "BMI Status");
        for (int i = 0; i < numberOfMembers; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-15s%n", i + 1, weights[i], heights[i], statuses[i]);
        }

        scanner.close();
    }
}