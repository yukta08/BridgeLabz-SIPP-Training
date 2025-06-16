import java.util.Scanner;

public class Question33 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        if (num == 0) {
            count = 1;
        } else {
            while (num != 0) {
                num /= 10;
                count++;
            }
        }

        System.out.println("Digits: " + count);
        sc.close();
    }
}
