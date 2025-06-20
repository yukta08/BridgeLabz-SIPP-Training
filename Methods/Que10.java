import java.util.*;

public class Que10 {

    public static int findRounds(double distance, double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        if (perimeter == 0) {
            return 0;
        }
        int rounds = (int) Math.ceil(distance / perimeter);
        return rounds;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sides of the triangular park:");
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        double distance = 5000;

        int rounds = findRounds(distance, side1, side2, side3);
        System.out.println("The athlete must complete " + rounds + " rounds to cover 5 km.");
    }
}