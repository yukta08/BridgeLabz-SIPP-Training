import java.util.Scanner;

public class Que4 {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        int remainder = number % divisor;
        int quotient = number / divisor;
        result[0] = remainder;
        result[1] = quotient;
        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int divisor = sc.nextInt();

        findRemainderAndQuotient(number, divisor);
        int result[] = findRemainderAndQuotient(number, divisor);
        System.out.println("Remainder: " + result[0]);
        System.out.println("Quotient: " + result[1]);

    }
}
