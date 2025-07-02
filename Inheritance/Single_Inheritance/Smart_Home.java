import java.util.*;

// Superclass for generic smart home device
class Device 
{
    String deviceId;  // Unique device ID
    String status;    // Status of the device (e.g., ON, OFF)

    // Constructor to initialize common device attributes
    Device(String deviceId, String status) 
    {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display generic device status
    void displayStatus() 
    {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass representing a thermostat device
class Thermostat extends Device 
{
    double temperatureSetting;  // Current temperature setting

    // Constructor to initialize thermostat-specific attributes along with device
    Thermostat(String deviceId, String status, double temperatureSetting) 
    {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // Overridden method to display complete thermostat status
    @Override
    void displayStatus() 
    {
        super.displayStatus();  // Call parent display method
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class to simulate the smart home system
public class Smart_Home 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Get device details from user
        System.out.print("Enter Device ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Device Status (ON/OFF): ");
        String status = sc.nextLine();

        System.out.print("Enter Temperature Setting (°C): ");
        double temp = sc.nextDouble();

        // Create Thermostat object
        Thermostat t1 = new Thermostat(id, status, temp);

        // Display the status of the thermostat
        System.out.println("\n--- Thermostat Device Status ---");
        t1.displayStatus();
    }
}
