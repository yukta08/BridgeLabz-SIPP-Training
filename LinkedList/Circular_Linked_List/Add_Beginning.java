import java.util.*;

public class Add_Beginning {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node tail = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter value to add at beginning: ");
            int val = sc.nextInt();
            addAtBeginning(val);
            display();
            System.out.print("Add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
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
