import java.util.*;

// Class to represent an inventory item
class Item 
{
    String itemCode;   // Unique item code
    String itemName;   // Name of the item
    double price;      // Price of a single unit

    // Method to take item details as input
    void getDetails(Scanner sc) 
    {
        System.out.print("Enter item code: ");
        itemCode = sc.nextLine();

        System.out.print("Enter item name: ");
        itemName = sc.nextLine();

        System.out.print("Enter item price: ");
        price = sc.nextDouble();
    }

    // Method to display item details and total cost
    void displayWithTotal(int quantity) 
    {
        System.out.println("----- Item Details -----");
        System.out.println("Code: " + itemCode);
        System.out.println("Name: " + itemName);
        System.out.println("Price: ₹" + price);
        double total = price * quantity;
        System.out.println("Total Cost for " + quantity + " unit(s): ₹" + total);
    }
}

// Main class to run the program
public class InventoryTracker 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Item item = new Item();           // Create Item object

        item.getDetails(sc);              // Input item details

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();      // Read quantity

        item.displayWithTotal(quantity);  // Show item details and total cost
    }
}
