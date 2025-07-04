import java.util.*;

public class Delete_Middle {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    static Node tail = null;

    public static void main(String[] args) {
        add(100);
        add(200);
        add(300);
        add(400);

        Scanner sc = new Scanner(System.in);
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
        if (len < 1) {
            System.out.println("List is empty.");
            return;
        }

        int mid = len / 2;
        deleteAtPosition(mid);
    }

    static void deleteAtPosition(int pos) {
        if (tail == null) return;

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

    static int getLength() {
        if (tail == null) return 0;

        int count = 0;
        Node temp = tail.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != tail.next);
        return count;
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
