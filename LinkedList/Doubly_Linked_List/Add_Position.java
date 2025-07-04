import java.util.*;

public class Add_Position {

    static class Node {
        int data;
        Node prev, next;

        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    static Node head = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter value to add: ");
            int value = sc.nextInt();
            System.out.print("Enter position (0-based): ");
            int pos = sc.nextInt();
            addAtPosition(value, pos);
            display();
            System.out.print("Add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void addAtPosition(int value, int pos) {
        Node newNode = new Node(value);

        if (pos == 0 || head == null) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
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
        newNode.prev = current;

        if (current.next != null)
            current.next.prev = newNode;

        current.next = newNode;
    }

    static void display() {
        Node temp = head;
        System.out.print("DLL (head → tail): ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
