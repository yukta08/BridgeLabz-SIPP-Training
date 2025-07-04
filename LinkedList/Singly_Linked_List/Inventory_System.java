import java.util.*;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head;

    // Add item at beginning
    void addAtBeginning(Item item) {
        item.next = head;
        head = item;
    }

    // Add item at end
    void addAtEnd(Item item) {
        if (head == null) {
            head = item;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = item;
    }

    // Add item at a specific position
    void addAtPosition(Item item, int pos) {
        if (pos == 0) {
            addAtBeginning(item);
            return;
        }
        Item temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        item.next = temp.next;
        temp.next = item;
    }

    // Remove item by ID
    void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next == null) System.out.println("Item not found.");
        else temp.next = temp.next.next;
    }

    // Update quantity
    void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by ID or Name
    void search(String keyword) {
        boolean found = false;
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.id).equals(keyword) || temp.name.equalsIgnoreCase(keyword)) {
                System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: ₹" + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    // Total inventory value
    void totalValue() {
        double sum = 0;
        Item temp = head;
        while (temp != null) {
            sum += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + sum);
    }

    // Display all items
    void displayAll() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: ₹" + temp.price);
            temp = temp.next;
        }
    }

    // Sort by name
    void sortByName(boolean ascending) {
        head = mergeSort(head, "name", ascending);
        System.out.println("Sorted by name.");
    }

    // Sort by price
    void sortByPrice(boolean ascending) {
        head = mergeSort(head, "price", ascending);
        System.out.println("Sorted by price.");
    }

    // Merge Sort on linked list
    private Item mergeSort(Item h, String key, boolean asc) {
        if (h == null || h.next == null) return h;
        Item middle = getMiddle(h);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(h, key, asc);
        Item right = mergeSort(nextOfMiddle, key, asc);
        return sortedMerge(left, right, key, asc);
    }

    private Item sortedMerge(Item a, Item b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;
        boolean condition;
        if (key.equals("name")) {
            condition = asc ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        Item result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, key, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, key, asc);
        }
        return result;
    }

    private Item getMiddle(Item h) {
        if (h == null) return h;
        Item slow = h, fast = h.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class Inventory_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n1. Add Item\n2. Remove Item\n3. Update Quantity\n4. Search");
            System.out.println("5. Total Value\n6. Display All\n7. Sort by Name\n8. Sort by Price\n9. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Position (begin/end/pos): ");
                    String pos = sc.nextLine().toLowerCase();
                    Item item = new Item(name, id, qty, price);
                    if (pos.equals("begin")) inventory.addAtBeginning(item);
                    else if (pos.equals("end")) inventory.addAtEnd(item);
                    else {
                        System.out.print("Enter position index: ");
                        int p = sc.nextInt();
                        inventory.addAtPosition(item, p);
                    }
                }
                case 2 -> {
                    System.out.print("Enter Item ID to remove: ");
                    int id = sc.nextInt();
                    inventory.removeById(id);
                }
                case 3 -> {
                    System.out.print("Enter Item ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int qty = sc.nextInt();
                    inventory.updateQuantity(id, qty);
                }
                case 4 -> {
                    System.out.print("Enter ID or Name to search: ");
                    String key = sc.nextLine();
                    inventory.search(key);
                }
                case 5 -> inventory.totalValue();
                case 6 -> inventory.displayAll();
                case 7 -> {
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sortByName(asc);
                }
                case 8 -> {
                    System.out.print("Ascending? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    inventory.sortByPrice(asc);
                }
                case 9 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
