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

    static Node head = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;
        do {
            System.out.print("Enter value to add at beginning: ");
            int val = sc.nextInt();
            addAtBeginning(val);
            display();
            System.out.print("Do you want to add another? (y/n): ");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    static void addAtBeginning(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
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
