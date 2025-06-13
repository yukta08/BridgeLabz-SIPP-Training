import java.util.*;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner (System.in);
        System.out.print("Enter the number:");
        int radius = sc.nextInt();
        double volume = (4/3) * 3.14*radius*radius*radius;
        System.out.println("The volume of the earth is: "+volume);

    }
}
