import java.util.Scanner;

public class Question40 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        int original = num;

        while (original != 0) {
            int digit = original % 10;
            sum += digit * digit * digit;
            original /= 10;
        }

        if (sum == num) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
        sc.close();
    }
}
