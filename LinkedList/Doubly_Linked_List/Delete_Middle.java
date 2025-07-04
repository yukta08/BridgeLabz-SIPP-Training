import java.util.*;

public class Delete_Middle {

    static class Node {
        int data;
        Node prev, next;

        Node(int d) {
            data = d;
        }
    }

    static Node head = null;

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
            System.out.print("Delete another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void deleteInMiddle() {
        int len = getLength();
        if (len < 1) {
            System.out.println("List is too short.");
            return;
        }

        int mid = len / 2;
        deleteAtPosition(mid);
    }

    static void deleteAtPosition(int pos) {
        if (head == null) return;

        Node current = head;
        for (int i = 0; i < pos && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        if (current.prev != null) current.prev.next = current.next;
        if (current.next != null) current.next.prev = current.prev;
        if (pos == 0) head = current.next;
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

    static void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
            newNode.prev = current;
        }
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
