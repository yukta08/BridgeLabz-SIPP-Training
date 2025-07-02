import java.util.*;

// Superclass Vehicle
class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Method to display vehicle info
    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass Car
class Car extends Vehicle {
    int seatCapacity;

    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Vehicle Type: Car");
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Subclass Truck
class Truck extends Vehicle {
    double loadCapacity;

    Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Vehicle Type: Truck");
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {
    boolean hasHelmetStorage;

    Motorcycle(int maxSpeed, String fuelType, boolean hasHelmetStorage) {
        super(maxSpeed, fuelType);
        this.hasHelmetStorage = hasHelmetStorage;
    }

    @Override
    void displayInfo() {
        System.out.println("Vehicle Type: Motorcycle");
        super.displayInfo();
        System.out.println("Helmet Storage: " + (hasHelmetStorage ? "Yes" : "No"));
    }
}

// Main class
public class Transport_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[3];

        // Input for Car
        System.out.println("Enter details for Car:");
        System.out.print("Max Speed: ");
        int carSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String carFuel = sc.nextLine();
        System.out.print("Seat Capacity: ");
        int carSeats = sc.nextInt();
        vehicles[0] = new Car(carSpeed, carFuel, carSeats);

        // Input for Truck
        System.out.println("\nEnter details for Truck:");
        System.out.print("Max Speed: ");
        int truckSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String truckFuel = sc.nextLine();
        System.out.print("Load Capacity (in tons): ");
        double truckLoad = sc.nextDouble();
        vehicles[1] = new Truck(truckSpeed, truckFuel, truckLoad);

        // Input for Motorcycle
        System.out.println("\nEnter details for Motorcycle:");
        System.out.print("Max Speed: ");
        int bikeSpeed = sc.nextInt();
        sc.nextLine();
        System.out.print("Fuel Type: ");
        String bikeFuel = sc.nextLine();
        System.out.print("Has Helmet Storage (true/false): ");
        boolean hasStorage = sc.nextBoolean();
        vehicles[2] = new Motorcycle(bikeSpeed, bikeFuel, hasStorage);

        // Display all vehicle details using polymorphism
        System.out.println("\n--- Vehicle Details ---");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
