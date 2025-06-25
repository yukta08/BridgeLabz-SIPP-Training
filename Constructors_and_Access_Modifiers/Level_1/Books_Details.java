import java.util.*;

// Class to represent a Book
class Book 
{
    String title;    // Title of the book
    String author;   // Author of the book
    double price;    // Price of the book

    // Default constructor
    Book() 
    {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) 
    {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void display() 
    {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

// Main class to test the Book class
public class Book_Details 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Creating book using default constructor
        Book book1 = new Book();
        System.out.println("Default Book Details:");
        book1.display();

        // Creating book using parameterized constructor
        System.out.println("\nEnter title, author, and price of the book:");
        String title = sc.nextLine();
        String author = sc.nextLine();
        double price = sc.nextDouble();
        Book book2 = new Book(title, author, price);

        System.out.println("\nParameterized Book Details:");
        book2.display();
    }
}
