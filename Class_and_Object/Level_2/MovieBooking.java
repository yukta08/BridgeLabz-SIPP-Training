import java.util.*;

// Class to represent a movie ticket
class MovieTicket 
{
    String movieName;     // Name of the movie
    String seatNumber;    // Seat number assigned
    double price;         // Ticket price

    // Method to book a ticket by taking user input
    void bookTicket(Scanner sc) 
    {
        System.out.print("Enter movie name: ");
        movieName = sc.nextLine();

        System.out.print("Enter seat number: ");
        seatNumber = sc.nextLine();

        System.out.print("Enter ticket price: ");
        price = sc.nextDouble();
    }

    // Method to display the ticket details
    void displayTicket() 
    {
        System.out.println("\n----- Ticket Details -----");
        System.out.println("Movie: " + movieName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }
}

// Main class to run the program
public class MovieBooking 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();

        ticket.bookTicket(sc);       // Collect ticket details from user
        ticket.displayTicket();      // Show the booked ticket info
    }
}
