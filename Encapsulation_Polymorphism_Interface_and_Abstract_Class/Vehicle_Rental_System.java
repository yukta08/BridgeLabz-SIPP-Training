import java.util.Scanner;

// Abstract base class representing a vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor to initialize common vehicle attributes
    public Vehicle(String number, String type, double rate) {
        vehicleNumber = number;
        this.type = type;
        rentalRate = rate;
    }

    // Getter methods for accessing private attributes
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    // Abstract method to calculate rental cost (to be implemented by subclasses)
    public abstract double calculateRentalCost(int days);
}

// Interface representing insurable behavior
interface Insurable {
    double calculateInsurance();         // Method to calculate insurance premium
    String getInsuranceDetails();        // Method to return policy detail string
}

// Car class extends Vehicle and implements Insurable
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    // Constructor to initialize car details
    public Car(String number, double rate, String policy) {
        super(number, "Car", rate);
        this.policyNumber = policy;
    }

    // Rental cost = daily rate × number of days
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Fixed insurance cost for a car
    public double calculateInsurance() {
        return 1000;
    }

    // Return car insurance details
    public String getInsuranceDetails() {
        return "Car Insurance: " + policyNumber;
    }
}

// Bike class extends Vehicle and implements Insurable
class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    // Constructor to initialize bike details
    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate);
        this.policyNumber = policy;
    }

    // Rental cost = daily rate × number of days
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Fixed insurance cost for a bike
    public double calculateInsurance() {
        return 300;
    }

    // Return bike insurance details
    public String getInsuranceDetails() {
        return "Bike Insurance: " + policyNumber;
    }
}

// Truck class extends Vehicle but does not implement Insurable
class Truck extends Vehicle {

    // Constructor to initialize truck details
    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    // Rental cost includes a flat service charge of ₹500
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500;
    }
}

// Main class to test and run the vehicle rental system
public class Vehicle_Rental_System {

    // Method to process the rental for any Vehicle type
    public static void processRental(Vehicle v, int days) {
        System.out.println("\nVehicle: " + v.getType());
        System.out.println("Number: " + v.getVehicleNumber());
        System.out.println("Rental Cost: ₹" + v.calculateRentalCost(days));

        // Check if the vehicle is insurable and display insurance details
        if (v instanceof Insurable) {
            Insurable ins = (Insurable) v;
            System.out.println(ins.getInsuranceDetails());
            System.out.println("Insurance: ₹" + ins.calculateInsurance());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[3]; // Array to store 3 vehicle types

        // Input details for Car
        System.out.print("Enter Car Number: ");
        String carNo = sc.nextLine();
        System.out.print("Enter Rate: ");
        double carRate = sc.nextDouble();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Policy: ");
        String carPol = sc.nextLine();
        vehicles[0] = new Car(carNo, carRate, carPol);

        // Input details for Bike
        System.out.print("Enter Bike Number: ");
        String bikeNo = sc.nextLine();
        System.out.print("Enter Rate: ");
        double bikeRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Policy: ");
        String bikePol = sc.nextLine();
        vehicles[1] = new Bike(bikeNo, bikeRate, bikePol);

        // Input details for Truck
        System.out.print("Enter Truck Number: ");
        String truckNo = sc.nextLine();
        System.out.print("Enter Rate: ");
        double truckRate = sc.nextDouble();
        vehicles[2] = new Truck(truckNo, truckRate);

        // Input number of rental days
        System.out.print("Enter number of rental days: ");
        int days = sc.nextInt();

        // Process rental for all vehicles
        for (Vehicle v : vehicles) {
            processRental(v, days);
        }
    }
}
