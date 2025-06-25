import java.util.*;

class Vehicle {
    static double registrationFee = 500.0;
    final String registrationNumber;
    String ownerName, vehicleType;

    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    void displayVehicle() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }
}

class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Registration Number: ");
        String reg = sc.nextLine();
        System.out.print("Enter Owner Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Vehicle Type: ");
        String type = sc.nextLine();
        Vehicle v = new Vehicle(reg, name, type);
        v.displayVehicle();
    }
}
