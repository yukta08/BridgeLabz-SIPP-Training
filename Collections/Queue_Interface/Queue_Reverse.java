import java.util.*;

public class Queue_Reverse {

    // Recursively reverse the queue
    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        int front = queue.remove();  // Remove front
        reverse(queue);              // Reverse remaining
        queue.add(front);            // Enqueue removed element at the end
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter number of elements in the queue: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        System.out.println("Original Queue: " + queue);

        reverse(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
