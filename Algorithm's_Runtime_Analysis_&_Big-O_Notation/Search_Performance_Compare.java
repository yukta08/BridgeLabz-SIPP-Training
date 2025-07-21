import java.util.*;

public class Search_Performance_Compare 
{
    // Linear Search: O(N) time complexity
    public static int linearSearch(int[] arr, int target) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search: O(log N) time complexity (assumes sorted array)
    public static int binarySearch(int[] arr, int target) 
    {
        int l = 0, r = arr.length - 1;

        while (l <= r) 
        {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // User input for dataset size
        System.out.print("Enter dataset size: ");
        int n = sc.nextInt();

        int[] data = new int[n];
        Random rand = new Random();

        // Fill array with random values
        for (int i = 0; i < n; i++) 
        {
            data[i] = rand.nextInt(1_000_000);
        }

        // Input target to search
        System.out.print("Enter target value to search: ");
        int target = sc.nextInt();

        // Measure linear search time
        long start = System.nanoTime();
        int lResult = linearSearch(data, target);
        long lTime = System.nanoTime() - start;

        // Sort array before binary search
        Arrays.sort(data);

        // Measure binary search time
        start = System.nanoTime();
        int bResult = binarySearch(data, target);
        long bTime = System.nanoTime() - start;

        // Output results
        System.out.println("\nLinear Search: " + (lResult != -1 ? "Found" : "Not Found") +
                           ", Time = " + lTime / 1_000_000.0 + " ms");

        System.out.println("Binary Search: " + (bResult != -1 ? "Found" : "Not Found") +
                           ", Time = " + bTime / 1_000_000.0 + " ms");

        sc.close();
    }
}
