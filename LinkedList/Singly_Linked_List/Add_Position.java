import java.util.*;

public class Add_Position {

    // Node class for linked list
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter value to insert: ");
            int value = sc.nextInt();
            System.out.print("Enter position (0-based index): ");
            int position = sc.nextInt();
            addAtPosition(value, position);
            display();
            System.out.print("Do you want to insert another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    // Insert node at a specific position
    static void addAtPosition(int value, int pos) {
        Node newNode = new Node(value);

        if (pos == 0 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Display the linked list
    static void display() {
        Node temp = head;
        System.out.print("Current List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
