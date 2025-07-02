import java.util.*;

// Superclass Book
class Book 
{
    String title;             // Title of the book
    int publicationYear;      // Year the book was published

    // Constructor to initialize book details
    Book(String title, int publicationYear) 
    {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book details
    void displayInfo() 
    {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass Author extending Book
class Author extends Book 
{
    String name;     // Name of the author
    String bio;      // Short bio of the author

    // Constructor to initialize author and book details
    Author(String title, int publicationYear, String name, String bio) 
    {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Overridden method to display book and author info
    @Override
    void displayInfo() 
    {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class to run the application
public class Library_Manager 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Input book and author details
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Publication Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Author Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Bio: ");
        String bio = sc.nextLine();

        // Create Author object (which includes Book details)
        Author bookWithAuthor = new Author(title, year, name, bio);

        // Display complete information
        System.out.println("\n--- Book and Author Details ---");
        bookWithAuthor.displayInfo();
    }
}
