import java.util.*;

public class Counting_Sort_Student_Ages 
{

    // Perform counting sort for ages (range 10–18)
    public void sort(int[] arr) 
    {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];     // Count frequency
        int[] output = new int[arr.length]; // Sorted output

        // Count each age
        for (int age : arr) 
	{
            count[age - minAge]++;
        }

        // Accumulate counts
        for (int i = 1; i < range; i++) 
	{
            count[i] += count[i - 1];
        }

        // Build output array (stable sort)
        for (int i = arr.length - 1; i >= 0; i--) 
	{
            int age = arr[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy back to original array
        for (int i = 0; i < arr.length; i++) 
	{
            arr[i] = output[i];
        }
    }

    // Print the array
    public void print(int[] arr) 
    {
        for (int age : arr) 
	{
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Counting_Sort_Student_Ages cs = new Counting_Sort_Student_Ages();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter " + n + " ages (between 10 and 18):");
        for (int i = 0; i < n; i++) 
	{
            ages[i] = sc.nextInt();
        }

        cs.sort(ages);

        System.out.println("Sorted student ages:");
        cs.print(ages);

        sc.close();
    }
}
