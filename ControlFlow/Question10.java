//Write a program to check if the first, second, or third number is the largest of the three.
import java.util.Scanner;
public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean isALargest = a > b && a > c;
        boolean isBLargest = b > a && b > c;
        boolean isCLargest = c > a && c > b;
    
        System.out.println("Is a the largest? " + isALargest);
        System.out.println("Is b the largest? " + isBLargest);
        System.out.println("Is c the largest? " + isCLargest);
        sc.close();
    }
}
