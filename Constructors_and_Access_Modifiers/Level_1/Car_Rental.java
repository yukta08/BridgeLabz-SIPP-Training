import java.util.*;

// Class to represent a Car Rental booking
class CarRental 
{
    String customerName;   // Name of the customer
    String carModel;       // Model of the car rented
    int rentalDays;        // Number of days for the rental
    double ratePerDay = 1500.0;  // Fixed rate per day

    // Default constructor
    CarRental() 
    {
        customerName = "Unknown";
        carModel = "Not Assigned";
        rentalDays = 0;
    }

    // Parameterized constructor to initialize rental details
    CarRental(String customerName, String carModel, int rentalDays) 
    {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total rental cost
    double calculateTotalCost() 
    {
        return rentalDays * ratePerDay;
    }

    // Method to display the rental details
    void displayRentalDetails() 
    {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Rate Per Day: ₹" + ratePerDay);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }
}

// Main class to run the Car Rental system
public class Car_Rental 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Get user input for rental details
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Car Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Number of Rental Days: ");
        int days = sc.nextInt();

        // Create CarRental object using parameterized constructor
        CarRental rental = new CarRental(name, model, days);

        // Display the rental summary
        System.out.println("\n--- Rental Summary ---");
        rental.displayRentalDetails();
    }
}
