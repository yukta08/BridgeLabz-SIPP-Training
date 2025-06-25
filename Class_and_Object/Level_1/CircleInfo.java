import java.util.Scanner;

class Circle {
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    void display() {
        System.out.printf("\nArea of Circle       : %.2f\n", calculateArea());
        System.out.printf("Circumference of Circle: %.2f\n", calculateCircumference());
    }
}

class CircleInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Radius of Circle: ");
        double radius = sc.nextDouble();

        Circle c = new Circle(radius);
        c.display();

        sc.close();
    }
}