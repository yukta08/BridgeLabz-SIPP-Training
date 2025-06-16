//Rewrite the program 10 to find the sum until the user enters 0 or a negative number using while loop and break statement
import java.util.Scanner;
public class Question8 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;

        while (true) {
            double num = sc.nextDouble();
            if (num <= 0) {
                break;
            }
            total += num;
        }

        System.out.println("Total Sum: " + total);
        sc.close();
    }
}
