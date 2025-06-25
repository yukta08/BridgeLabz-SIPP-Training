// Superclass representing a generic Book
class Book 
{
    public String ISBN;       // Public variable: can be accessed from anywhere
    protected String title;   // Protected variable: accessible within subclass and same package
    private String author;    // Private variable: accessible only within this class

    // Constructor to initialize ISBN and title
    Book(String ISBN, String title) 
    {
        this.ISBN = ISBN;
        this.title = title;
    }

    // Public method to set the author's name (write access to private variable)
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    // Public method to get the author's name (read access to private variable)
    public String getAuthor() 
    {
        return author;
    }

    // Method to display basic book details
    public void displayBook() 
    {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}

// Subclass representing an EBook that extends Book
class EBook extends Book 
{
    String fileFormat;   // Specific attribute for EBook

    // Constructor for EBook class, using super to call parent constructor
    EBook(String ISBN, String title, String fileFormat) 
    {
        super(ISBN, title);  // initialize ISBN and title using parent constructor
        this.fileFormat = fileFormat;
    }

    // Method to display EBook details including public and protected fields
    public void displayEBook() 
    {
        System.out.println("E-Book ISBN: " + ISBN);         // public member from Book
        System.out.println("E-Book Title: " + title);       // protected member from Book
        System.out.println("Format: " + fileFormat);
    }
}

// Main class to run the library system
public class Library_System 
{
    public static void main(String[] args) 
    {
        // Create an instance of Book
        Book book1 = new Book("978-1234567890", "Core Java");
        book1.setAuthor("John Smith");
        System.out.println("--- Book Details ---");
        book1.displayBook();

        System.out.println();

        // Create an instance of EBook
        EBook ebook1 = new EBook("978-0987654321", "Advanced Java", "PDF");
        ebook1.setAuthor("Alice Walker");
        System.out.println("--- E-Book Details ---");
        ebook1.displayEBook();
        System.out.println("Author: " + ebook1.getAuthor()); // accessing private field via public method
    }
}
