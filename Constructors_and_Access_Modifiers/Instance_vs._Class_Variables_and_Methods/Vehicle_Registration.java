import java.util.*;

// Class to manage vehicle registration details
class Vehicle 
{
    String ownerName;         // Instance variable to store owner's name
    String vehicleType;       // Instance variable to store vehicle type

    static double registrationFee = 500.0; // Class variable (common for all vehicles)

    // Constructor to initialize instance variables
    Vehicle(String ownerName, String vehicleType) 
    {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    void displayVehicleDetails() 
    {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class method to update registration fee for all vehicles
    static void updateRegistrationFee(double newFee) 
    {
        registrationFee = newFee;
    }
}

// Main class to run the program
public class Vehicle_Registration 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Updating registration fee
        System.out.print("Enter updated registration fee: ");
        double newFee = sc.nextDouble();
        Vehicle.updateRegistrationFee(newFee);
        sc.nextLine(); // Clear buffer

        // Input for first vehicle
        System.out.print("Enter owner's name for vehicle 1: ");
        String owner1 = sc.nextLine();
        System.out.print("Enter vehicle type for vehicle 1: ");
        String type1 = sc.nextLine();
        Vehicle v1 = new Vehicle(owner1, type1);

        // Input for second vehicle
        System.out.print("Enter owner's name for vehicle 2: ");
        String owner2 = sc.nextLine();
        System.out.print("Enter vehicle type for vehicle 2: ");
        String type2 = sc.nextLine();
        Vehicle v2 = new Vehicle(owner2, type2);

        // Display vehicle details
        System.out.println("\n--- Vehicle 1 Details ---");
        v1.displayVehicleDetails();

        System.out.println("\n--- Vehicle 2 Details ---");
        v2.displayVehicleDetails();
    }
}
