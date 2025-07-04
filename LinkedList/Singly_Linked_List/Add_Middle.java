import java.util.*;

public class Add_Middle {

    // Node class to represent each element of the linked list
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
        char choice;

        do {
            System.out.print("Enter value to insert in the middle: ");
            int value = sc.nextInt();
            addInMiddle(value);
            display();
            System.out.print("Do you want to insert another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    // Method to insert a new node at the middle of the list
    static void addInMiddle(int value) {
        Node newNode = new Node(value);
        int len = getLength();
        int pos = len / 2;

        if (head == null || pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to calculate the length of the list
    static int getLength() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Method to display the list
    static void display() {
        Node temp = head;
        System.out.print("Current List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
