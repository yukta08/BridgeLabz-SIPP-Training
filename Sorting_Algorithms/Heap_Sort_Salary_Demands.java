import java.util.*;

public class Heap_Sort_Salary_Demands 
{

    // Perform heap sort on array
    public void sort(int[] arr) 
    {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) 
	{
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) 
	{
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Reheapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify subtree rooted at index i
    private void heapify(int[] arr, int n, int i) 
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger
        if (left < n && arr[left] > arr[largest]) 
	{
            largest = left;
        }

        // If right child is larger
        if (right < n && arr[right] > arr[largest]) 
	{
            largest = right;
        }

        // If root is not largest, swap and recurse
        if (largest != i) 
	{
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Print array elements
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
        Heap_Sort_Salary_Demands hs = new Heap_Sort_Salary_Demands();

        System.out.print("Enter number of applicants: ");
        int n = sc.nextInt();

        int[] salaries = new int[n];
        System.out.println("Enter expected salaries of " + n + " applicants:");
        for (int i = 0; i < n; i++) 
	{
            salaries[i] = sc.nextInt();
        }

        hs.sort(salaries);

        System.out.println("Sorted salaries in ascending order:");
        hs.print(salaries);

        sc.close();
    }
}
