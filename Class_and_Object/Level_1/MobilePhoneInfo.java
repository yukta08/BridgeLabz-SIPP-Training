import java.util.*;

// Class to represent a Mobile Phone
class MobilePhone 
{
    String brand;     // Brand of the phone
    String model;     // Model name/number
    double price;     // Price of the phone

    // Method to get phone details from user
    void getDetails(Scanner sc) 
    {
        System.out.print("Enter phone brand: ");
        brand = sc.nextLine();

        System.out.print("Enter phone model: ");
        model = sc.nextLine();

        System.out.print("Enter phone price: ");
        price = sc.nextDouble();
    }

    // Method to display all details of the phone
    void displayDetails() 
    {
        System.out.println("----- Mobile Phone Details -----");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: ₹" + price);
    }
}

// Main class to execute the program
public class MobilePhoneInfo 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        MobilePhone phone = new MobilePhone();  // Create MobilePhone object

        phone.getDetails(sc);                   // Take input
        phone.displayDetails();                 // Show phone info
    }
}
