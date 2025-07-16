import java.util.Scanner;

// Abstract class representing a generic food item
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor to initialize common food item properties
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters for food item attributes
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Method to display item details along with total price
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + calculateTotalPrice());
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateTotalPrice();
}

// Interface to define discount behavior
interface Discountable {
    double applyDiscount();             // Method to calculate discount amount
    String getDiscountDetails();        // Method to display discount info
}

// Subclass representing a vegetarian food item
class VegItem extends FoodItem implements Discountable {

    // Constructor for VegItem
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    // Calculate total price for veg items (no extra charges)
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    // Apply 10% discount
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    // Return discount description
    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

// Subclass representing a non-vegetarian food item
class NonVegItem extends FoodItem implements Discountable {

    // Constructor for NonVegItem
    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    // Calculate total price with an extra charge of ₹20
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 20;
    }

    // Apply 5% discount
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    // Return discount description
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

// Main class to simulate the food delivery system
public class Online_Food_Delivery_System {

    // Method to process any food item order
    public static void processOrder(FoodItem item) {
        item.getItemDetails();  // Display item info and base total

        // If the item supports discount, calculate and display it
        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            System.out.println(d.getDiscountDetails());
            System.out.println("Discount: " + d.applyDiscount());
            System.out.println("Payable Amount: " + (item.calculateTotalPrice() - d.applyDiscount()));
        }

        System.out.println();  // Blank line between orders
    }

    // Main method to accept input and process orders
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodItem[] items = new FoodItem[2];  // Array to store 1 veg and 1 non-veg item

        // Input details for Veg Item
        System.out.print("Enter Veg Item Name: ");
        String vName = sc.nextLine();
        System.out.print("Price: ");
        double vPrice = sc.nextDouble();
        System.out.print("Quantity: ");
        int vQty = sc.nextInt();
        sc.nextLine();  // Consume newline
        items[0] = new VegItem(vName, vPrice, vQty);

        // Input details for Non-Veg Item
        System.out.print("\nEnter Non-Veg Item Name: ");
        String nvName = sc.nextLine();
        System.out.print("Price: ");
        double nvPrice = sc.nextDouble();
        System.out.print("Quantity: ");
        int nvQty = sc.nextInt();
        items[1] = new NonVegItem(nvName, nvPrice, nvQty);

        // Process both items
        for (FoodItem item : items) {
            processOrder(item);
        }
    }
}
