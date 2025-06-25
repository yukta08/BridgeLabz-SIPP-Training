import java.util.*;

// Class to represent a Product
class Product 
{
    String productName;            // Instance variable to store the product name
    double price;                  // Instance variable to store the product price

    static int totalProducts = 0;  // Class variable to track total number of products

    // Constructor to initialize product details
    Product(String productName, double price) 
    {
        this.productName = productName;
        this.price = price;
        totalProducts++;  // Increment total count when a product is created
    }

    // Instance method to display the product details
    void displayProductDetails() 
    {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class method to display the total number of products created
    static void displayTotalProducts() 
    {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

// Main class to run the Product Inventory system
public class Product_Inventory 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Create first product
        System.out.print("Enter Product 1 Name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Product 1 Price: ");
        double price1 = sc.nextDouble();
        sc.nextLine(); // consume leftover newline
        Product p1 = new Product(name1, price1);

        // Create second product
        System.out.print("Enter Product 2 Name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Product 2 Price: ");
        double price2 = sc.nextDouble();
        Product p2 = new Product(name2, price2);

        // Display individual product details
        System.out.println("\n--- Product 1 Details ---");
        p1.displayProductDetails();

        System.out.println("\n--- Product 2 Details ---");
        p2.displayProductDetails();

        // Display total products created
        System.out.println();
        Product.displayTotalProducts();
    }
}
