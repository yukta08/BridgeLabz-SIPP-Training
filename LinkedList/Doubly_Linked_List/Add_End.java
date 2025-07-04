import java.util.*;

public class Add_End {

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
            System.out.print("Enter value to add at end: ");
            int value = sc.nextInt();
            addAtEnd(value);
            display();
            System.out.print("Add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
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
        newNode.prev = current;
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
