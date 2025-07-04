import java.util.*;

public class Delete_Position {

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
        addAtEnd(5);
        addAtEnd(15);
        addAtEnd(25);
        addAtEnd(35);

        char choice;
        do {
            System.out.println("Before Deletion:");
            display();
            System.out.print("Enter position to delete (0-based): ");
            int pos = sc.nextInt();
            deleteAtPosition(pos);
            System.out.println("After Deletion:");
            display();
            System.out.print("Delete again? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (pos == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        current.next = current.next.next;
    }

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
