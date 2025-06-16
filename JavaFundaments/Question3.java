//Create a Program that takes user input for Student Fee and University Discount to compute the discounted amount and discounted price the student will pay for the course.
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total course fee: ₹");
        double Fees = scanner.nextDouble();
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = scanner.nextDouble();
        double discountAmount = (Fees * discountPercent) / 100;
        double finalFee = Fees - discountAmount;

        System.out.println(" The discount amount is INR"+" "+discountAmount + " "+ " and final discounted fee is INR "+" "+finalFee);
    }
}
