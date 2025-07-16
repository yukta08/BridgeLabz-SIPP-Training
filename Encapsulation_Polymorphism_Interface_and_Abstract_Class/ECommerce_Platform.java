import java.util.Scanner;

// Abstract base class for all products
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor to initialize common product details
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters to access private fields
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Abstract method to be implemented for discount calculation
    public abstract double calculateDiscount();
}

// Interface to define tax behavior
interface Taxable {
    double calculateTax();              // Method to calculate tax
    String getTaxDetails();             // Method to return tax information
}

// Electronics product which includes tax and discount
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    // 10% discount on electronics
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    // 18% tax on electronics
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    // Return tax details
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing product which includes tax and discount
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    // 20% discount on clothing
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    // 5% tax on clothing
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    // Return tax details
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

// Groceries product which has discount but no tax
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    // 5% discount on groceries
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

// Main class to run the e-commerce platform system
public class ECommerce_Platform {

    // Method to print final price after applying discount and tax
    public static void printFinalPrice(Product p) {
        double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
        double discount = p.calculateDiscount();
        double finalPrice = p.getPrice() + tax - discount;

        System.out.println("\nProduct: " + p.getName());
        System.out.println("Price: " + p.getPrice());
        if (p instanceof Taxable) 
            System.out.println(((Taxable) p).getTaxDetails());
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + finalPrice);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[3];  // Array to store products

        // Input details for Electronics product
        System.out.print("Enter Electronics Name: ");
        String eName = sc.nextLine();
        System.out.print("Enter Price: ");
        double ePrice = sc.nextDouble();
        sc.nextLine(); // Consume newline
        products[0] = new Electronics(1, eName, ePrice);

        // Input details for Clothing product
        System.out.print("Enter Clothing Name: ");
        String cName = sc.nextLine();
        System.out.print("Enter Price: ");
        double cPrice = sc.nextDouble();
        sc.nextLine(); // Consume newline
        products[1] = new Clothing(2, cName, cPrice);

        // Input details for Grocery product
        System.out.print("Enter Grocery Name: ");
        String gName = sc.nextLine();
        System.out.print("Enter Price: ");
        double gPrice = sc.nextDouble();
        products[2] = new Groceries(3, gName, gPrice);

        // Display final prices of all products
        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}
