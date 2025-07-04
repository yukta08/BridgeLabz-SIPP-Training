import java.util.*;

public class Add_Position {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    static Node tail = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter value to add: ");
            int val = sc.nextInt();
            System.out.print("Enter position (0-based): ");
            int pos = sc.nextInt();
            addAtPosition(val, pos);
            display();
            System.out.print("Add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void addAtPosition(int val, int pos) {
        Node newNode = new Node(val);

        if (tail == null || pos == 0) {
            addAtBeginning(val);
            return;
        }

        Node current = tail.next;
        for (int i = 0; i < pos - 1 && current != tail; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
        }
    }

    static void addAtBeginning(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    static void display() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = tail.next;
        System.out.print("CLL (tail → head): ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println();
    }
}
