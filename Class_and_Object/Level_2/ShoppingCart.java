import java.util.*;

// Class to represent an item in the shopping cart
class CartItem 
{
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) 
    {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotal() 
    {
        return price * quantity;
    }
}

// Main class to manage the cart
public class ShoppingCart 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();

        while (true) 
        {
            System.out.println("\n1. Add Item\n2. Remove Item\n3. Display Total\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            if (choice == 1) 
            {
                System.out.print("Enter item name: ");
                String name = sc.nextLine();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                cart.add(new CartItem(name, price, qty));
                System.out.println("Item added to cart.");
            } 
            else if (choice == 2) 
            {
                System.out.print("Enter item name to remove: ");
                String name = sc.nextLine();
                boolean removed = false;
                for (int i = 0; i < cart.size(); i++) 
                {
                    if (cart.get(i).itemName.equalsIgnoreCase(name)) 
                    {
                        cart.remove(i);
                        removed = true;
                        System.out.println("Item removed.");
                        break;
                    }
                }
                if (!removed) 
                {
                    System.out.println("Item not found.");
                }
            } 
            else if (choice == 3) 
            {
                double total = 0;
                System.out.println("\nItems in Cart:");
                for (CartItem item : cart) 
                {
                    System.out.println(item.itemName + " x " + item.quantity + " = ₹" + item.getTotal());
                    total += item.getTotal();
                }
                System.out.println("Total Cost: ₹" + total);
            } 
            else if (choice == 4) 
            {
                System.out.println("Exiting...");
                break;
            } 
            else 
            {
                System.out.println("Invalid choice.");
            }
        }
    }
}
