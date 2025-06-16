//The University is charging the student a fee of INR 125000 for the course. The University is willing to offer a discount of 10%. Write a program to find the discounted amount and discounted price the student will pay for the course.
public class Question6 {
    public static void main(String[] args) {
        int courseFee = 125000;
        double discount = 10.0;
        double discountAmount = (courseFee * discount) / 100;
        double discountedPrice = courseFee - discountAmount;
        System.out.print(" The discount amount is INR"+" "+discountAmount+" "+" and final discounted fee is INR "+" "+discountedPrice);

    }
}
