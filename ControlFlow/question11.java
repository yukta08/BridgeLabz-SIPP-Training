//Write a program to find the sum of n natural numbers using while loop compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct.

import java.util.Scanner;

public class question11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0,sum2=0;
        int n =  sc.nextInt();
        int m = n;
        while(m>=1){
            sum = sum +m;
            m--;
        }
        sum2 = n*(n+1)/2;
        if(sum == sum2){
            System.out.println("Correct" );
        }else{
            System.out.println("Incorrect");
        }
        sc.close();    
}}
