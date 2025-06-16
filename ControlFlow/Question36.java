import java.util.Scanner;

public class Question36 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n, sum = 0;

        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (n % sum == 0) {
            System.out.println("Harshad Number");
        } else {
            System.out.println("Not a Harshad Number");
        }

        sc.close();
    }
}
