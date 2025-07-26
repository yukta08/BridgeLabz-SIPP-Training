import java.util.*;

class Circular_Buffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public Circular_Buffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void add(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            // Overwrite the oldest
            head = (head + 1) % capacity;
        }
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter buffer capacity: ");
        int cap = sc.nextInt();

        Circular_Buffer buffer = new Circular_Buffer(cap);

        while (true) {
            System.out.println("\n--- Circular Buffer Menu ---");
            System.out.println("1. Add value");
            System.out.println("2. Display buffer");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter value to add: ");
                    int val = sc.nextInt();
                    buffer.add(val);
                    break;
                case 2:
                    buffer.display();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
