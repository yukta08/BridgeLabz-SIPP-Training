import java.util.Scanner;

// Abstract base class for all Vehicles
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor to initialize vehicle details
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getter methods for encapsulated fields
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    // Display basic vehicle information
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per KM: ₹" + ratePerKm);
    }

    // Abstract method to calculate fare based on distance
    public abstract double calculateFare(double distance);
}

// GPS interface to be implemented by all vehicle types
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class inherits Vehicle and implements GPS
class Car extends Vehicle implements GPS {
    private String currentLocation;

    // Constructor to initialize Car with location
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = location;
    }

    // Car fare includes base charge of ₹50
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }

    // Get and update current location
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

// Bike class inherits Vehicle and implements GPS
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    // Constructor to initialize Bike
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = location;
    }

    // Bike fare = distance × rate per km
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    // Get and update location
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

// Auto class inherits Vehicle and implements GPS
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    // Constructor to initialize Auto
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = location;
    }

    // Auto fare includes ₹20 base charge
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    // Get and update location
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

// Main class to run the Ride Hailing Application
public class Ride_Hailing_Application {

    // Process ride for any vehicle: display details, location, and fare
    public static void processRide(Vehicle v, double distance) {
        v.getVehicleDetails(); // Basic vehicle info
        if (v instanceof GPS) {
            System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
        }
        System.out.println("Fare for " + distance + " KM: ₹" + v.calculateFare(distance));
        System.out.println();
    }

    // Main method to collect user input and simulate rides
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] rides = new Vehicle[3]; // Array to store Car, Bike, and Auto

        // Input details for Car
        System.out.print("Enter Car ID: ");
        String carId = sc.nextLine();
        System.out.print("Driver: ");
        String carDriver = sc.nextLine();
        System.out.print("Rate/km: ");
        double carRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Location: ");
        String carLoc = sc.nextLine();
        rides[0] = new Car(carId, carDriver, carRate, carLoc);

        // Input details for Bike
        System.out.print("\nEnter Bike ID: ");
        String bikeId = sc.nextLine();
        System.out.print("Driver: ");
        String bikeDriver = sc.nextLine();
        System.out.print("Rate/km: ");
        double bikeRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Location: ");
        String bikeLoc = sc.nextLine();
        rides[1] = new Bike(bikeId, bikeDriver, bikeRate, bikeLoc);

        // Input details for Auto
        System.out.print("\nEnter Auto ID: ");
        String autoId = sc.nextLine();
        System.out.print("Driver: ");
        String autoDriver = sc.nextLine();
        System.out.print("Rate/km: ");
        double autoRate = sc.nextDouble();
        sc.nextLine();
        System.out.print("Location: ");
        String autoLoc = sc.nextLine();
        rides[2] = new Auto(autoId, autoDriver, autoRate, autoLoc);

        // Enter common ride distance
        System.out.print("\nEnter ride distance in KM: ");
        double distance = sc.nextDouble();

        // Display ride summary for each vehicle
        for (Vehicle v : rides) {
            processRide(v, distance);
        }
    }
}
