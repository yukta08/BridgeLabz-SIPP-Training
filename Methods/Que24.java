import java.util.Random;

public class Que24 {
    public static void main(String[] args) {
        int numStudents = 10;
        int[][] scores = new int[numStudents][3];
        double[] totals = new double[numStudents];
        double[] averages = new double[numStudents];
        double[] percentages = new double[numStudents];

        Random rand = new Random();

        for (int i = 0; i < numStudents; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(91) + 10;
                sum += scores[i][j];
            }
            totals[i] = sum;
            averages[i] = sum / 3.0;
            percentages[i] = (sum / 300.0) * 100;
        }

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "Student", "Physics", "Chemistry", "Math", "Total",
                "Percentage");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10.2f %-10.2f%n",
                    "S" + (i + 1), scores[i][0], scores[i][1], scores[i][2], totals[i], percentages[i]);
        }
    }
}