import java.util.*;

public class Delete_Beginning {

    static class Node {
        int data;
        Node prev, next;

        Node(int d) {
            data = d;
        }
    }

    static Node head = null;

    public static void main(String[] args) {
        add(10);
        add(20);
        add(30);

        Scanner sc = new Scanner(System.in);
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

    static void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        }
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
