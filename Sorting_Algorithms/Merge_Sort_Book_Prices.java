import java.util.*;

public class Merge_Sort_Book_Prices 
{

    // Merge sort main method
    public void sort(int[] arr, int left, int right) 
    {
        if (left < right) 
	{
            int mid = left + (right - left) / 2;

            // Sort both halves
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted subarrays
    private void merge(int[] arr, int left, int mid, int right) 
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy elements to temporary arrays
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge sorted arrays
        while (i < n1 && j < n2) 
	{
            if (L[i] <= R[j]) 
	    {
                arr[k++] = L[i++];
            } 
	    else 
	    {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Print the array
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
        Merge_Sort_Book_Prices ms = new Merge_Sort_Book_Prices();

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter " + n + " book prices:");
        for (int i = 0; i < n; i++) 
	{
            prices[i] = sc.nextInt();
        }

        ms.sort(prices, 0, n - 1);

        System.out.println("Sorted book prices:");
        ms.print(prices);

        sc.close();
    }
}
