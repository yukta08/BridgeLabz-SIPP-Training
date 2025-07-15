import java.util.*;

public class Selection_Sort_Exam_Scores 
{

    // Perform selection sort on array
    public void sort(int[] arr) 
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) 
	{
            int minIdx = i;

            // Find index of minimum element in unsorted part
            for (int j = i + 1; j < n; j++) 
	    {
                if (arr[j] < arr[minIdx]) 
		{
                    minIdx = j;
                }
            }

            // Swap with first unsorted element
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
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
        Selection_Sort_Exam_Scores ss = new Selection_Sort_Exam_Scores();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter " + n + " exam scores:");
        for (int i = 0; i < n; i++) 
	{
            scores[i] = sc.nextInt();
        }

        ss.sort(scores);

        System.out.println("Sorted exam scores:");
        ss.print(scores);

        sc.close();
    }
}
