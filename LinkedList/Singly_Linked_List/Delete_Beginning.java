import java.util.*;

public class Delete_Beginning {

    // Node class for singly linked list
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

        // Pre-populate list for demonstration (optional)
        addAtEnd(10);
        addAtEnd(20);
        addAtEnd(30);

        char choice;
        do {
            System.out.println("Before Deletion:");
            display();
            deleteAtBeginning();
            System.out.println("After Deletion:");
            display();
            System.out.print("Delete again? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    // Delete node at beginning
    static void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
        } else {
            head = head.next;
        }
    }

    // Helper to add node at end (used to pre-fill list)
    static void addAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Display the list
    static void display() {
        Node temp = head;
        System.out.print("Current List: ");
        if (temp == null) {
            System.out.println("Empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
