// Write a Program to compute the volume of Earth in km^3 and miles^3
import java.util.*;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner (System.in);
        System.out.print("Enter the number:");
        int radius = sc.nextInt();
        double volume = (4/3) * 3.14*radius*radius*radius;
        System.out.println("The volume of the earth is: "+ volume + " and cubic miles is" + (volume*0.621371));

    }
}
