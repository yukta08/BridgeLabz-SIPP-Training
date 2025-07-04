import java.util.*;

public class Add_End {
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
            System.out.print("Enter value to add at end: ");
            int val = sc.nextInt();
            addAtEnd(val);
            display();
            System.out.print("Do you want to add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void addAtEnd(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = temp;
    }

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
