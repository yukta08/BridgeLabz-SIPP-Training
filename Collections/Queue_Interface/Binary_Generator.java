import java.util.*;

public class Binary_Generator {

    // Generate first N binary numbers using a queue
    public static List<String> generateBinary(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < N; i++) {
            String current = queue.remove();     // Get current binary
            result.add(current);                // Store in result

            queue.add(current + "0");           // Enqueue next
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        List<String> binaryNumbers = generateBinary(N);

        System.out.println("First " + N + " Binary Numbers:");
        for (String binary : binaryNumbers) {
            System.out.print(binary + " ");
        }
    }
}
