import java.util.*;

public class Custom_HashMap 
{

    // Node to store key-value pairs
    static class Node 
    {
        int key, value;
        Node next;

        Node(int key, int value) 
	{
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10;
    private final Node[] table;

    public Custom_HashMap() 
    {
        table = new Node[SIZE];
    }

    // Hash function
    private int hash(int key) 
    {
        return key % SIZE;
    }

    // Insert or update key-value pair
    public void put(int key, int value) 
    {
        int idx = hash(key);
        Node head = table[idx];

        while (head != null) 
	{
            if (head.key == key) 
	    {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[idx];
        table[idx] = newNode;
    }

    // Retrieve value by key
    public Integer get(int key) 
    {
        int idx = hash(key);
        Node head = table[idx];

        while (head != null) 
	{
            if (head.key == key) 
	    {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    // Remove key-value pair by key
    public void remove(int key) 
    {
        int idx = hash(key);
        Node head = table[idx];
        Node prev = null;

        while (head != null) 
	{
            if (head.key == key) 
	    {
                if (prev == null) 
		{
                    table[idx] = head.next;
                } 
		else 
		{
                    prev.next = head.next;
                }
                return;
            }

            prev = head;
            head = head.next;
        }
    }

    // Print entire hash map
    public void printMap() 
    {
        for (int i = 0; i < SIZE; i++) 
	{
            System.out.print("Bucket " + i + ": ");
            Node node = table[i];
            while (node != null) 
	    {
                System.out.print("[" + node.key + " -> " + node.value + "] ");
                node = node.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Custom_HashMap map = new Custom_HashMap();

        while (true) 
	{
            System.out.println("\n1. Put\n2. Get\n3. Remove\n4. Print Map\n5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) 
	    {
                System.out.print("Enter key: ");
                int key = sc.nextInt();
                System.out.print("Enter value: ");
                int val = sc.nextInt();
                map.put(key, val);
            } 
	    else if (ch == 2) 
	    {
                System.out.print("Enter key to retrieve: ");
                int key = sc.nextInt();
                Integer val = map.get(key);
                if (val != null) 
		{
                    System.out.println("Value: " + val);
                } 
		else 
		{
                    System.out.println("Key not found.");
                }
            } 
	    else if (ch == 3) 
	    {
                System.out.print("Enter key to remove: ");
                int key = sc.nextInt();
                map.remove(key);
            } 
	    else if (ch == 4) 
	    {
                map.printMap();
            } 
	    else if (ch == 5) 
	    {
                break;
            } 
	    else 
	    {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
