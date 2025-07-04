import java.util.*;

public class Add_Middle {

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
            System.out.print("Enter value to add in middle: ");
            int value = sc.nextInt();
            addInMiddle(value);
            display();
            System.out.print("Add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void addInMiddle(int value) {
        Node newNode = new Node(value);
        int len = getLength();
        int mid = len / 2;

        if (head == null || mid == 0) {
            addAtBeginning(value);
            return;
        }

        Node current = head;
        for (int i = 0; i < mid - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null)
            current.next.prev = newNode;

        current.next = newNode;
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

    static void addAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
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
