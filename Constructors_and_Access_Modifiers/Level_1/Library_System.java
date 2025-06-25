import java.util.*;

// Class to represent a Book in the Library
class Book 
{
    String title;           // Book title
    String author;          // Book author
    double price;           // Book price
    boolean available;      // Availability status

    // Constructor to initialize book details
    Book(String title, String author, double price, boolean available) 
    {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    // Method to borrow the book
    void borrowBook() 
    {
        if (available) 
        {
            available = false;
            System.out.println("You have successfully borrowed \"" + title + "\".");
        } 
        else 
        {
            System.out.println("Sorry, \"" + title + "\" is currently not available.");
        }
    }

    // Method to display book details
    void displayDetails() 
    {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }
}

// Main class to run the Library Book System
public class Library_System 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Input book details from user
        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter book author: ");
        String author = sc.nextLine();

        System.out.print("Enter book price: ");
        double price = sc.nextDouble();

        // Initial availability set to true when book is created
        Book book = new Book(title, author, price, true);

        System.out.println("\nBook Details:");
        book.displayDetails();  // Show book details

        System.out.println("\nAttempting to borrow the book:");
        book.borrowBook();      // Try borrowing the book

        System.out.println("\nBook Details After Borrowing:");
        book.displayDetails();  // Show status after borrowing
    }
}
