import java.util.*;

// Class to represent a Circle
class Circle 
{
    double radius;  // Radius of the circle

    // Default constructor calling parameterized constructor with a default value
    Circle() 
    {
        this(1.0);  // Default radius is 1.0
    }

    // Parameterized constructor
    Circle(double radius) 
    {
        this.radius = radius;
    }

    // Method to calculate area of the circle
    double getArea() 
    {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference of the circle
    double getCircumference() 
    {
        return 2 * Math.PI * radius;
    }

    // Method to display details
    void display() 
    {
        System.out.println("Radius: " + radius);
        System.out.printf("Area: %.2f\n", getArea());
        System.out.printf("Circumference: %.2f\n", getCircumference());
    }
}

// Main class to test Circle functionality
public class Circle_Calculations 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Using default constructor
        Circle c1 = new Circle();
        System.out.println("Default Circle:");
        c1.display();

        // Using parameterized constructor
        System.out.print("\nEnter radius for custom circle: ");
        double r = sc.nextDouble();
        Circle c2 = new Circle(r);
        System.out.println("Custom Circle:");
        c2.display();
    }
}
