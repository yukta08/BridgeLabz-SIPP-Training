import java.util.*;

// Base class representing a general order
class Order 
{
    String orderId;         // Order ID
    String orderDate;       // Order date

    // Constructor to initialize order attributes
    Order(String orderId, String orderDate) 
    {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get current order status
    String getOrderStatus() 
    {
        return "Order Placed";
    }

    // Method to display order info
    void display() 
    {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Subclass representing a shipped order
class ShippedOrder extends Order 
{
    String trackingNumber;   // Tracking number for shipment

    // Constructor to initialize order and shipping info
    ShippedOrder(String orderId, String orderDate, String trackingNumber) 
    {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // Override status method for shipped order
    @Override
    String getOrderStatus() 
    {
        return "Order Shipped";
    }

    // Display method extended
    @Override
    void display() 
    {
        super.display();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass representing a delivered order
class DeliveredOrder extends ShippedOrder 
{
    String deliveryDate;     // Delivery date

    // Constructor to initialize full order info
    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) 
    {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // Override status for delivered
    @Override
    String getOrderStatus() 
    {
        return "Order Delivered";
    }

    // Final display method
    @Override
    void display() 
    {
        super.display();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class to run the system
public class Retail_Order_System 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter Order ID: ");
        String orderId = sc.nextLine();

        System.out.print("Enter Order Date (YYYY-MM-DD): ");
        String orderDate = sc.nextLine();

        System.out.print("Enter Tracking Number: ");
        String trackingNumber = sc.nextLine();

        System.out.print("Enter Delivery Date (YYYY-MM-DD): ");
        String deliveryDate = sc.nextLine();

        // Create DeliveredOrder object
        DeliveredOrder order = new DeliveredOrder(orderId, orderDate, trackingNumber, deliveryDate);

        // Display full order info
        System.out.println("\n--- Order Summary ---");
        order.display();
    }
}
