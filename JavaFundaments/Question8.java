 //Write a program that takes your height in centimeters and converts it into feet and inches//
import java.util.*;
 class Question8{
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        System.out.println("Enter your height in centimeters:");
        int height= sc.nextInt();
        double inches = height / 2.54;
        double feet = inches / 12;
        System.out.println("Your Height in cm is"+" "+height+" while in feet is"+" "+feet+" "+" and inches is"+" "+inches);

    }
}