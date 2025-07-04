import java.util.*;

public class Delete_Middle {

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
        addAtEnd(10);
        addAtEnd(20);
        addAtEnd(30);
        addAtEnd(40);

        char choice;
        do {
            System.out.println("Before Deletion:");
            display();
            deleteInMiddle();
            System.out.println("After Deletion:");
            display();
            System.out.print("Delete again? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void deleteInMiddle() {
        int len = getLength();
        if (len == 0) {
            System.out.println("List is empty.");
            return;
        }
        int mid = len / 2;
        deleteAtPosition(mid);
    }

    static void deleteAtPosition(int pos) {
        if (head == null) return;

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

    static int getLength() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
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
