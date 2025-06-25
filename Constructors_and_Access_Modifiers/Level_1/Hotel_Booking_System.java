import java.util.*;

// Class to represent a hotel booking
class HotelBooking 
{
    String guestName;
    String roomType;
    int nights;

    // Default constructor initializing default values
    HotelBooking() 
    {
        guestName = "Unknown Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor to initialize with user input
    HotelBooking(String guestName, String roomType, int nights) 
    {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor to create a copy of an existing HotelBooking object
    HotelBooking(HotelBooking other) 
    {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking details
    void displayBooking() 
    {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
    }
}

// Main class to test HotelBooking
public class Hotel_Booking_System 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Creating object using default constructor
        HotelBooking defaultBooking = new HotelBooking();
        System.out.println("\nDefault Booking:");
        defaultBooking.displayBooking();

        // Taking user input for parameterized constructor
        System.out.print("\nEnter guest name: ");
        String name = sc.nextLine();

        System.out.print("Enter room type (e.g., Deluxe, Suite): ");
        String room = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        // Creating object using parameterized constructor
        HotelBooking customBooking = new HotelBooking(name, room, nights);
        System.out.println("\nCustom Booking:");
        customBooking.displayBooking();

        // Creating object using copy constructor
        HotelBooking copiedBooking = new HotelBooking(customBooking);
        System.out.println("\nCopied Booking:");
        copiedBooking.displayBooking();
    }
}
