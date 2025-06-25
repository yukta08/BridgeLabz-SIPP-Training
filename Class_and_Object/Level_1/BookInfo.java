import java.util.*;

// Class to represent a book
class Book 
{
    String title;     // Title of the book
    String author;    // Author of the book
    double price;     // Price of the book

    // Method to take book details as input
    void getDetails(Scanner sc) 
    {
        System.out.print("Enter book title: ");
        title = sc.nextLine();

        System.out.print("Enter author name: ");
        author = sc.nextLine();

        System.out.print("Enter book price: ");
        price = sc.nextDouble();
    }

    // Method to display book details
    void display() 
    {
        System.out.println("----- Book Details -----");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }
}

// Main class to run the program
public class BookInfo 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Book b = new Book();   // Create Book object

        b.getDetails(sc);      // Input details
        b.display();           // Show details
    }
}
