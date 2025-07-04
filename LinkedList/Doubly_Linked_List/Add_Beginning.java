import java.util.*;

public class Add_Beginning {

    // Node class for Doubly Linked List
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
            System.out.print("Enter value to add at beginning: ");
            int value = sc.nextInt();
            addAtBeginning(value);
            display();
            System.out.print("Add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    // Insert at the beginning
    static void addAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Display list forward
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
