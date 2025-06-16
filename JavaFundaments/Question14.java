//Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the total purchase price.

import java.util.Scanner;

public class Question14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int unitPrice = sc.nextInt();
        int quantity = sc.nextInt();

        int total = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + total +
                " if the quantity " + quantity + " and the unit price is INR " + unitPrice);
    }
    
}
