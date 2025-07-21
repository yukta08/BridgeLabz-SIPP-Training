import java.util.*;

// ===== CLASS: Fibonacci_Compare =====
// Compares recursive vs iterative Fibonacci computation performance
public class Fibonacci_Compare 
{
    // Recursive method (O(2^N))
    public static int fibRec(int n) 
    {
        if (n <= 1) return n;
        return fibRec(n - 1) + fibRec(n - 2);
    }

    // Iterative method (O(N))
    public static int fibItr(int n) 
    {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) 
        {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N for Fibonacci: ");
        int n = sc.nextInt();

        long start, time;

        // Iterative Fibonacci
        start = System.nanoTime();
        int iter = fibItr(n);
        time = System.nanoTime() - start;
        System.out.println("Iterative Result: " + iter + ", Time: " + time / 1_000_000.0 + " ms");

        // Recursive Fibonacci
        if (n <= 40)  // prevent very long execution
        {
            start = System.nanoTime();
            int rec = fibRec(n);
            time = System.nanoTime() - start;
            System.out.println("Recursive Result: " + rec + ", Time: " + time / 1_000_000.0 + " ms");
        }
        else 
        {
            System.out.println("Recursive Result: Skipped (N too large for safe recursion)");
        }

        sc.close();
    }
}
