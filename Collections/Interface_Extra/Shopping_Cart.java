import java.util.*;

class Shopping_Cart 
{

    // HashMap: Product → Price
    private Map<String, Double> productPriceMap = new HashMap<>();

    // LinkedHashMap: Product → Quantity (Insertion order preserved)
    private Map<String, Integer> cart = new LinkedHashMap<>();

    // Add a product to the cart
    public void addProduct(String product, double price, int quantity) 
    {
        productPriceMap.put(product, price);

        if (cart.containsKey(product)) 
        {
            cart.put(product, cart.get(product) + quantity);  // update quantity
        } 
        else 
        {
            cart.put(product, quantity);
        }
    }

    // Display cart items in order added
    public void displayCartOrder() 
    {
        System.out.println(" Cart (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) 
        {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPriceMap.get(product);
            System.out.println(product + " → Qty: " + quantity + ", Price: ₹" + price);
        }
    }

    // Display items sorted by price
    public void displaySortedByPrice() 
    {
        System.out.println("\n Items Sorted by Price:");

        TreeMap<Double, List<String>> priceToProducts = new TreeMap<>();

        for (String product : cart.keySet()) 
        {
            double price = productPriceMap.get(product);

            priceToProducts.putIfAbsent(price, new ArrayList<>());
            priceToProducts.get(price).add(product);
        }

        for (Map.Entry<Double, List<String>> entry : priceToProducts.entrySet()) 
        {
            double price = entry.getKey();
            for (String product : entry.getValue()) 
            {
                int quantity = cart.get(product);
                System.out.println(product + " → Qty: " + quantity + ", Price: ₹" + price);
            }
        }
    }

    // Calculate total
    public void displayTotalAmount() 
    {
        double total = 0;
        for (String product : cart.keySet()) 
        {
            total += productPriceMap.get(product) * cart.get(product);
        }
        System.out.println("\n Total Amount: ₹" + total);
    }

    public static void main(String[] args) 
    {
        Shopping_Cart cart = new Shopping_Cart();

        cart.addProduct("Milk", 45.0, 2);
        cart.addProduct("Bread", 30.0, 1);
        cart.addProduct("Eggs", 6.0, 12);
        cart.addProduct("Butter", 60.0, 1);

        cart.displayCartOrder();
        cart.displaySortedByPrice();
        cart.displayTotalAmount();
    }
}
