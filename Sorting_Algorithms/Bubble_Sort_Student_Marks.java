import java.util.*;

public class Bubble_Sort_Student_Marks 
{

    // Perform bubble sort on the array
    public void sort(int[] arr) 
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) 
	{
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) 
	    {
                if (arr[j] > arr[j + 1]) 
		{
                    // Swap if elements are out of order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred, array is sorted
            if (!swapped) break;
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
        Bubble_Sort_Student_Marks bs = new Bubble_Sort_Student_Marks();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        System.out.println("Enter marks of " + n + " students:");
        for (int i = 0; i < n; i++) 
	{
            marks[i] = sc.nextInt();
        }

        bs.sort(marks);

        System.out.println("Sorted marks in ascending order:");
        bs.print(marks);

        sc.close();
    }
}
