import java.util.Scanner;

public class Question34 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int phy = sc.nextInt();

        System.out.print("Enter marks for Chemistry: ");
        int chem = sc.nextInt();

        System.out.print("Enter marks for Math: ");
        int math = sc.nextInt();

        int total = phy + chem + math;
        double avg = total / 3.0;

        String grade = "";
        String remark = "";

        if (avg >= 80) {
            grade = "A";
            remark = "Level 4, above agency-normalized standards";
        } else if (avg >= 70) {
            grade = "B";
            remark = "Level 3, at agency-normalized standards";
        } else if (avg >= 60) {
            grade = "C";
            remark = "Level 2, below, but approaching agency-normalized standards";
        } else if (avg >= 50) {
            grade = "D";
            remark = "Level 1, well below agency-normalized standards";
        } else if (avg >= 40) {
            grade = "E";
            remark = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remark = "Remedial standards";
        }

        System.out.println("\n--- Result ---");
        System.out.printf("Average Marks: %.2f%%\n", avg);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remark);

        sc.close();
    }
}
