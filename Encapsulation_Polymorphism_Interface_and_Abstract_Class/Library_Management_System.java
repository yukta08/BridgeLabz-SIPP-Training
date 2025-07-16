import java.util.Scanner;

// Abstract base class representing any library item
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    // Constructor to initialize item ID, title, and author
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getter methods for private fields
    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // Abstract method to be implemented by all subclasses
    public abstract int getLoanDuration();

    // Method to display item details
    public void getItemDetails() {
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration (days): " + getLoanDuration());
    }
}

// Interface defining reservable behavior
interface Reservable {
    void reserveItem(String userName);      // Reserve item for a user
    boolean checkAvailability();            // Check if the item is available
}

// Book class - extends LibraryItem and implements Reservable
class Book extends LibraryItem implements Reservable {
    private boolean available = true;

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;  // Loan duration for books
    }

    public void reserveItem(String userName) {
        available = false;
        System.out.println("Book reserved for " + userName);
    }

    public boolean checkAvailability() {
        return available;
    }
}

// Magazine class - extends LibraryItem and implements Reservable
class Magazine extends LibraryItem implements Reservable {
    private boolean available = true;

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;  // Loan duration for magazines
    }

    public void reserveItem(String userName) {
        available = false;
        System.out.println("Magazine reserved for " + userName);
    }

    public boolean checkAvailability() {
        return available;
    }
}

// DVD class - extends LibraryItem and implements Reservable
class DVD extends LibraryItem implements Reservable {
    private boolean available = true;

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;  // Loan duration for DVDs
    }

    public void reserveItem(String userName) {
        available = false;
        System.out.println("DVD reserved for " + userName);
    }

    public boolean checkAvailability() {
        return available;
    }
}

// Main class to run the Library Management System
public class Library_Management_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryItem[] items = new LibraryItem[3];  // Array to hold 3 items

        // --- Input for Book ---
        System.out.print("Enter Book ID: ");
        int bId = sc.nextInt();
        sc.nextLine();  // Consume leftover newline
        System.out.print("Title: ");
        String bTitle = sc.nextLine();
        System.out.print("Author: ");
        String bAuthor = sc.nextLine();
        items[0] = new Book(bId, bTitle, bAuthor);

        // --- Input for Magazine ---
        System.out.print("\nEnter Magazine ID: ");
        int mId = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String mTitle = sc.nextLine();
        System.out.print("Author: ");
        String mAuthor = sc.nextLine();
        items[1] = new Magazine(mId, mTitle, mAuthor);

        // --- Input for DVD ---
        System.out.print("\nEnter DVD ID: ");
        int dId = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        String dTitle = sc.nextLine();
        System.out.print("Author: ");
        String dAuthor = sc.nextLine();
        items[2] = new DVD(dId, dTitle, dAuthor);

        // --- Display and Process Each Item ---
        for (LibraryItem item : items) {
            item.getItemDetails();  // Display base details (common)

            // If item supports reservation, process it
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + r.checkAvailability());
                r.reserveItem("User123");  // Reserve for a sample user
                System.out.println("Available After Reservation: " + r.checkAvailability());
            }

            System.out.println();  // Line break for clarity
        }
    }
}
