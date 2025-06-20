import java.util.*;

public class Que9 {
    public static int naturalNo(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;

        }
        return sum;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = naturalNo(number);
        System.out.println(number + " natural numbers sum is " + sum);

    }

}
