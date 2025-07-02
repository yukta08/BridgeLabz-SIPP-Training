import java.util.*;

// Superclass Vehicle
class Vehicle 
{
    String model;
    int maxSpeed;

    // Constructor to initialize vehicle details
    Vehicle(String model, int maxSpeed) 
    {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    // Method to display vehicle details
    void displayInfo() 
    {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface Refuelable with refuel() method
interface Refuelable 
{
    void refuel();
}

// Subclass ElectricVehicle (inherits from Vehicle)
class ElectricVehicle extends Vehicle 
{
    int batteryLevel;

    // Constructor
    ElectricVehicle(String model, int maxSpeed, int batteryLevel) 
    {
        super(model, maxSpeed);
        this.batteryLevel = batteryLevel;
    }

    // Method specific to ElectricVehicle
    void charge() 
    {
        System.out.println("Charging electric vehicle... Current battery: " + batteryLevel + "%");
    }
}

// Subclass PetrolVehicle (inherits from Vehicle, implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable 
{
    int fuelLevel;

    // Constructor
    PetrolVehicle(String model, int maxSpeed, int fuelLevel) 
    {
        super(model, maxSpeed);
        this.fuelLevel = fuelLevel;
    }

    // Implement refuel() method from Refuelable
    public void refuel() 
    {
        System.out.println("Refueling petrol vehicle... Current fuel: " + fuelLevel + "%");
    }
}

// Main class to test the Vehicle Management System
public class Vehicle_System 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 for Electric Vehicle or 2 for Petrol Vehicle:");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter model name: ");
        String model = sc.nextLine();

        System.out.print("Enter max speed: ");
        int speed = sc.nextInt();

        if (choice == 1) 
        {
            System.out.print("Enter battery level (%): ");
            int battery = sc.nextInt();
            ElectricVehicle ev = new ElectricVehicle(model, speed, battery);
            System.out.println("\n--- Electric Vehicle Info ---");
            ev.displayInfo();
            ev.charge();
        } 
        else if (choice == 2) 
        {
            System.out.print("Enter fuel level (%): ");
            int fuel = sc.nextInt();
            PetrolVehicle pv = new PetrolVehicle(model, speed, fuel);
            System.out.println("\n--- Petrol Vehicle Info ---");
            pv.displayInfo();
            pv.refuel();
        } 
        else 
        {
            System.out.println("Invalid choice.");
        }
    }
}
