import java.util.*;

public class Insertion_Sort_Employee_IDs 
{

    // Perform insertion sort on the array
    public void sort(int[] arr) 
    {
        for (int i = 1; i < arr.length; i++) 
	{
            int key = arr[i];
            int j = i - 1;

            // Shift elements of the sorted part that are greater than key
            while (j >= 0 && arr[j] > key) 
	    {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the key in its correct position
            arr[j + 1] = key;
        }
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
        Insertion_Sort_Employee_IDs is = new Insertion_Sort_Employee_IDs();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] empIDs = new int[n];
        System.out.println("Enter " + n + " employee IDs:");
        for (int i = 0; i < n; i++) 
	{
            empIDs[i] = sc.nextInt();
        }

        is.sort(empIDs);

        System.out.println("Sorted employee IDs:");
        is.print(empIDs);

        sc.close();
    }
}
