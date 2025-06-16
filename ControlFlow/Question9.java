//Write a program to count down the number from the user input value to 1 using a for loop for a rocket launch

import java.util.Scanner;

public class Question9 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = sc.nextInt();
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Lift Off!");
        sc.close();
    }
}
