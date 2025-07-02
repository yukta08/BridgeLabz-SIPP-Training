import java.util.*;

// Superclass Animal
class Animal {
    String name;
    int age;

    // Constructor for Animal
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden by subclasses
    void makeSound() {
        System.out.println(name + " makes a sound.");
    }
}

// Subclass Dog
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// Subclass Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Tweet!");
    }
}

// Main class
public class Animal_Hierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Dog
        System.out.print("Enter dog name: ");
        String dogName = sc.nextLine();
        System.out.print("Enter dog age: ");
        int dogAge = sc.nextInt();
        sc.nextLine(); // consume newline
        Dog dog = new Dog(dogName, dogAge);

        // Create Cat
        System.out.print("Enter cat name: ");
        String catName = sc.nextLine();
        System.out.print("Enter cat age: ");
        int catAge = sc.nextInt();
        sc.nextLine();
        Cat cat = new Cat(catName, catAge);

        // Create Bird
        System.out.print("Enter bird name: ");
        String birdName = sc.nextLine();
        System.out.print("Enter bird age: ");
        int birdAge = sc.nextInt();
        Bird bird = new Bird(birdName, birdAge);

        // Display sounds (polymorphism in action)
        System.out.println("\nAnimal Sounds:");
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}
