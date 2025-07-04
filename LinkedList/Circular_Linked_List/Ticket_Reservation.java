import java.util.*;

// Node class representing a ticket
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Class for managing the circular linked list of tickets
class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add a new ticket at the end
    public void addTicket(int id, String cname, String mname, String seat, String time) {
        Ticket newTicket = new Ticket(id, cname, mname, seat, time);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        System.out.println("Ticket booked successfully.");
    }

    // Remove ticket by ticket ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }

        Ticket current = head;
        Ticket prev = tail;
        boolean found = false;

        do {
            if (current.ticketId == id) {
                found = true;
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head) head = head.next;
                    if (current == tail) tail = prev;
                }
                System.out.println("Ticket with ID " + id + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found)
            System.out.println("Ticket ID not found.");
    }

    // Display all booked tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("\n--- Booked Tickets ---");
        do {
            System.out.println("Ticket ID: " + current.ticketId);
            System.out.println("Customer: " + current.customerName);
            System.out.println("Movie: " + current.movieName);
            System.out.println("Seat: " + current.seatNumber);
            System.out.println("Booking Time: " + current.bookingTime);
            System.out.println("---------------------------");
            current = current.next;
        } while (current != head);
    }

    // Search by customer or movie name
    public void search(String key) {
        if (head == null) {
            System.out.println("No tickets found.");
            return;
        }

        boolean found = false;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(key) || current.movieName.equalsIgnoreCase(key)) {
                System.out.println("Ticket ID: " + current.ticketId);
                System.out.println("Customer: " + current.customerName);
                System.out.println("Movie: " + current.movieName);
                System.out.println("Seat: " + current.seatNumber);
                System.out.println("Booking Time: " + current.bookingTime);
                System.out.println("---------------------------");
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found)
            System.out.println("No matching records found.");
    }

    // Count total tickets
    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}

// Main class to run the ticket system
public class Ticket_Reservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n=== Online Ticket Reservation System ===");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Search Ticket by Customer or Movie Name");
            System.out.println("5. Total Tickets Booked");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String mname = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, cname, mname, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int delId = sc.nextInt();
                    system.removeTicket(delId);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer or Movie Name to search: ");
                    String key = sc.nextLine();
                    system.search(key);
                    break;

                case 5:
                    System.out.println("Total Tickets Booked: " + system.countTickets());
                    break;

                case 6:
                    System.out.println("Exiting system.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
