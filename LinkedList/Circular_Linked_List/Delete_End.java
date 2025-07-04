import java.util.*;

public class Delete_End {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    static Node tail = null;

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("Before Deletion:");
            display();
            deleteAtEnd();
            System.out.println("After Deletion:");
            display();
            System.out.print("Delete again? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void deleteAtEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        if (tail.next == tail) {
            tail = null;
            return;
        }

        Node current = tail.next;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = tail.next;
        tail = current;
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
