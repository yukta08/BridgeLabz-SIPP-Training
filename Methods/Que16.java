import java.util.Scanner;

public class Que16 {
    public static boolean isNaturalNumber(int n) {
        return n > 0;
    }

    public static int recursiveSum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + recursiveSum(n - 1);
        }
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer (natural number): ");
        int n = sc.nextInt();

        if (isNaturalNumber(n)) {
            int sumRecursive = recursiveSum(n);
            int sumFormula = formulaSum(n);

            System.out.println("Sum using recursion: " + sumRecursive);
            System.out.println("Sum using formula: " + sumFormula);

            if (sumRecursive == sumFormula) {
                System.out.println("Both results are equal. The computation is correct!");
            } else {
                System.out.println("Results differ! Check the implementation.");
            }
        } else {
            System.out.println("Invalid input! Please enter a positive integer (natural number).");
        }

        sc.close();
    }
}