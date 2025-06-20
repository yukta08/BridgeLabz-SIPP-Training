import java.util.Scanner;

public class Que21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficients a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Roots: " + root1 + " and " + root2);
        } else if (delta == 0) {
            double root = -b / (2 * a);
            System.out.println("Root: " + root);
        } else {
            System.out.println("No real roots.");
        }
        scanner.close();
    }
}