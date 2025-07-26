import java.util.*;

class Stack_Using_Queues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public Stack_Using_Queues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x); // Always enqueue to q1
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move all but last to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove(); // Last added element

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        // Move all but last to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.remove(); // Last added
        q2.add(top);           // Put it back

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void print() {
        System.out.println("Stack contents (bottom to top): " + q1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack_Using_Queues stack = new Stack_Using_Queues();

        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Is Empty");
            System.out.println("5. Print Stack");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    try {
                        System.out.println("Popped: " + stack.pop());
                    } catch (NoSuchElementException e) {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Top: " + stack.top());
                    } catch (NoSuchElementException e) {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Is Empty: " + stack.isEmpty());
                    break;
                case 5:
                    stack.print();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
