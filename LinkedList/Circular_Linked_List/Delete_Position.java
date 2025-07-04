import java.util.*;

public class Delete_Position {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    static Node tail = null;

    public static void main(String[] args) {
        add(5);
        add(10);
        add(15);
        add(20);

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Before Deletion:");
            display();
            System.out.print("Enter position to delete (0-based): ");
            int pos = sc.nextInt();
            deleteAtPosition(pos);
            System.out.println("After Deletion:");
            display();
            System.out.print("Delete another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void deleteAtPosition(int pos) {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        if (pos == 0) {
            deleteAtBeginning();
            return;
        }

        Node current = tail.next;
        for (int i = 0; i < pos - 1 && current.next != tail.next; i++) {
            current = current.next;
        }

        if (current.next == tail) {
            tail = current;
        }

        current.next = current.next.next;
    }

    static void deleteAtBeginning() {
        if (tail == null) return;

        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
    }

    static void add(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            tail = newNode;
            newNode.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
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
