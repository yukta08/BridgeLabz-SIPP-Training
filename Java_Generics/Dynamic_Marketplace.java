import java.util.*;

// ===== Interface for Product Categories =====
interface ProductCategory 
{
    String getCategoryName();
}

// ===== Concrete Category Implementations =====
class BookCategory implements ProductCategory 
{
    public String getCategoryName() 
    {
        return "Books";
    }
}

class ClothingCategory implements ProductCategory 
{
    public String getCategoryName() 
    {
        return "Clothing";
    }
}

class GadgetCategory implements ProductCategory 
{
    public String getCategoryName() 
    {
        return "Gadgets";
    }
}

// ===== Generic Product Class with Bounded Type =====
class Product<T extends ProductCategory> 
{
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) 
    {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }

    public T getCategory() 
    {
        return category;
    }

    public void applyDiscount(double percentage) 
    {
        price = price - (price * percentage / 100);
    }

    public void display() 
    {
        System.out.println("[" + category.getCategoryName() + "] " + name + " - ₹" + price);
    }
}

// ===== Utility Class with Generic Method =====
class Marketplace_Utility 
{
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) 
    {
        product.applyDiscount(percentage);
        System.out.println("Discount applied to: " + product.getName());
    }

    public static void displayAll(List<? extends Product<?>> productList) 
    {
        if (productList.isEmpty()) 
        {
            System.out.println("No products available in the catalog.");
            return;
        }

        for (Product<?> product : productList) 
        {
            product.display();
        }
    }
}

// ===== Main Class =====
public class Dynamic_Marketplace 
{
    public static void main(String[] args) 
    {
        List<Product<?>> catalog = new ArrayList<>();

        // Add products to catalog
        catalog.add(new Product<>("Clean Code", 450.0, new BookCategory()));
        catalog.add(new Product<>("Casual Shirt", 799.0, new ClothingCategory()));
        catalog.add(new Product<>("Bluetooth Speaker", 1599.0, new GadgetCategory()));

        // Display all products
        System.out.println("=== Product Catalog ===");
        Marketplace_Utility.displayAll(catalog);

        // Apply discount to all
        System.out.println("\n=== Applying 15% Discount ===");
        for (Product<?> product : catalog) 
        {
            Marketplace_Utility.applyDiscount(product, 15.0);
        }

        // Display updated products
        System.out.println("\n=== Updated Catalog ===");
        Marketplace_Utility.displayAll(catalog);
    }
}
