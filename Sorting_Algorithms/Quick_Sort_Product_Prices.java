import java.util.*;

public class Quick_Sort_Product_Prices 
{

    // Perform quick sort on array
    public void sort(int[] arr, int low, int high) 
    {
        if (low < high) 
	{
            int pi = partition(arr, low, high); // partition index
            sort(arr, low, pi - 1);  // sort left
            sort(arr, pi + 1, high); // sort right
        }
    }

    // Partition the array around the pivot (last element)
    private int partition(int[] arr, int low, int high) 
    {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) 
	{
            if (arr[j] < pivot) 
	    {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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
        Quick_Sort_Product_Prices qs = new Quick_Sort_Product_Prices();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter " + n + " product prices:");
        for (int i = 0; i < n; i++) 
	{
            prices[i] = sc.nextInt();
        }

        qs.sort(prices, 0, n - 1);

        System.out.println("Sorted product prices:");
        qs.print(prices);

        sc.close();
    }
}
