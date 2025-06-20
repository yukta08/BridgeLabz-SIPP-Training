import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Que23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }

        System.out.print("Factors: " + factors + "\n");

        int sum = 0, product = 1, sumSquares = 0;
        for (int f : factors) {
            sum += f;
            product *= f;
            sumSquares += Math.pow(f, 2);
        }

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Sum of squares: " + sumSquares);

        sc.close();
    }
}