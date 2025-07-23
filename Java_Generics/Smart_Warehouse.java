import java.util.*;

// ===== Abstract Superclass =====
abstract class WarehouseItem 
{
    private String name;
    private double price;

    public WarehouseItem(String name, double price) 
    {
        this.name = name;
        this.price = price;
    }

    public String getName() 
    { 
        return name; 
    }

    public double getPrice() 
    { 
        return price; 
    }

    public abstract String getCategory();

    public void displayItem() 
    {
        System.out.println("[" + getCategory() + "] " + name + " - ₹" + price);
    }
}

// ===== Concrete Item Types =====
class Electronics extends WarehouseItem 
{
    public Electronics(String name, double price) 
    {
        super(name, price);
    }

    public String getCategory() 
    {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem 
{
    public Groceries(String name, double price) 
    {
        super(name, price);
    }

    public String getCategory() 
    {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem 
{
    public Furniture(String name, double price) 
    {
        super(name, price);
    }

    public String getCategory() 
    {
        return "Furniture";
    }
}

// ===== Generic Storage Class with Bounded Type =====
class Storage<T extends WarehouseItem> 
{
    private List<T> items;

    public Storage() 
    {
        items = new ArrayList<>();
    }

    public void addItem(T item) 
    {
        items.add(item);
    }

    public List<T> getItems() 
    {
        return items;
    }
}

// ===== Utility Class with Wildcard Method =====
class WarehouseUtility 
{
    public static void displayAllItems(List<? extends WarehouseItem> itemList) 
    {
        if (itemList.isEmpty()) 
        {
            System.out.println("No items in this storage.");
            return;
        }
        for (WarehouseItem item : itemList) 
        {
            item.displayItem();
        }
    }
}

// ===== Main Program =====
public class Smart_Warehouse 
{
    public static void main(String[] args) 
    {
        // Create Storage for each item type
        Storage<Electronics> electronicStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to each storage
        electronicStorage.addItem(new Electronics("Laptop", 75000));
        electronicStorage.addItem(new Electronics("Headphones", 2500));

        groceryStorage.addItem(new Groceries("Rice 5kg", 300));
        groceryStorage.addItem(new Groceries("Milk", 60));

        furnitureStorage.addItem(new Furniture("Sofa", 15000));
        furnitureStorage.addItem(new Furniture("Table", 5000));

        // Display contents of each storage
        System.out.println("=== Electronics Storage ===");
        WarehouseUtility.displayAllItems(electronicStorage.getItems());

        System.out.println("\n=== Grocery Storage ===");
        WarehouseUtility.displayAllItems(groceryStorage.getItems());

        System.out.println("\n=== Furniture Storage ===");
        WarehouseUtility.displayAllItems(furnitureStorage.getItems());
    }
}
