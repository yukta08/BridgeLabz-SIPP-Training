//Write a Program to find the factorial of an integer entered by the user.

import java.util.Scanner;
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :");
        int n = sc.nextInt();
        int fact = 1;
        for(int i=1;i<=n;i++){
            fact= fact*i;
        }
        System.out.println("factorial :" + fact );
        sc.close();
    }
}
