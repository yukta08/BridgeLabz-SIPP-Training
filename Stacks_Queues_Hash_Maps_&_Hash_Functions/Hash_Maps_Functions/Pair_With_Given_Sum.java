import java.util.*;

public class Pair_With_Given_Sum 
{

    // Check if any pair sums to target
    public boolean hasPair(int[] arr, int target) 
    {
        Set<Integer> seen = new HashSet<>();

        for (int val : arr) 
	{
            if (seen.contains(target - val)) 
	    {
                return true;
            }
            seen.add(val);
        }

        return false;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Pair_With_Given_Sum pgs = new Pair_With_Given_Sum();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
	{
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        boolean found = pgs.hasPair(arr, target);

        if (found) 
	{
            System.out.println("Yes, a pair with the given sum exists.");
        } 
	else 
	{
            System.out.println("No, such a pair does not exist.");
        }

        sc.close();
    }
}
