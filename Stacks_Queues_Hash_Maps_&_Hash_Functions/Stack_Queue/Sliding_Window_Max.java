import java.util.*;

public class Sliding_Window_Max 
{

    // Return max in each window of size k
    public int[] maxInWindows(int[] arr, int k) 
    {
        int n = arr.length;
        if (n == 0 || k <= 0 || k > n) return new int[0];

        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // holds indices

        for (int i = 0; i < n; i++) 
	{
            // Remove indices out of current window
            while (!dq.isEmpty() && dq.peek() <= i - k) 
	    {
                dq.poll();
            }

            // Remove smaller values from back
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) 
	    {
                dq.pollLast();
            }

            dq.offer(i);

            // Record max once window starts filling
            if (i >= k - 1) 
	    {
                res[i - k + 1] = arr[dq.peek()];
            }
        }

        return res;
    }

    // Print array
    public void print(int[] arr) 
    {
        for (int val : arr) 
	{
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Sliding_Window_Max sw = new Sliding_Window_Max();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
	{
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        int[] result = sw.maxInWindows(arr, k);

        System.out.println("Maximums in each window:");
        sw.print(result);

        sc.close();
    }
}
