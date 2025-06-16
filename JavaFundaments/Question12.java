//Write a DoubleOperation program by taking a, b, and c as input values and print the results of the following operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also understand the Operator Precedence.

import java.util.Scanner;

public class Question12 {
    public static void main(String[] args) {;
        Scanner sc = new Scanner(System.in);
        double a =sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println("The results of Double Operations are " +
                result1 + ", " + result2 + ", " + result3 + ", " + result4);
    }
}
