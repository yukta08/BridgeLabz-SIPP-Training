import java.util.*;

public class Add_Middle {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    static Node tail = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter value to add in middle: ");
            int val = sc.nextInt();
            addInMiddle(val);
            display();
            System.out.print("Add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void addInMiddle(int val) {
        int len = getLength();
        int mid = len / 2;
        addAtPosition(val, mid);
    }

    static void addAtPosition(int val, int pos) {
        Node newNode = new Node(val);

        if (tail == null || pos == 0) {
            addAtBeginning(val);
            return;
        }

        Node current = tail.next;
        for (int i = 0; i < pos - 1 && current != tail; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == tail) {
            tail = newNode;
        }
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

    static void addAtBeginning(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
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
