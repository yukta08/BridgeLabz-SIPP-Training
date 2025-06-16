//Write a Program to find the factorial of an integer entered by the user.

import java.util.Scanner;
public class Question12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fact = 1;
        int n =  sc.nextInt();
        while(n>=1){
            fact = fact*n;
            n--;
        }System.out.println("Factorial :" + fact);
        sc.close();
    }
}
