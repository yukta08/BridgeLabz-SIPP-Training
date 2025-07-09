import java.util.*;

public class Two_Sum 
{

    // Return indices of two numbers that add up to target
    public int[] findIndices(int[] arr, int target) 
    {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) 
	{
            int diff = target - arr[i];

            if (map.containsKey(diff)) 
	    {
                return new int[] { map.get(diff), i };
            }

            map.put(arr[i], i);
        }

        return null; // no valid pair found
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Two_Sum ts = new Two_Sum();

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

        int[] res = ts.findIndices(arr, target);

        if (res != null) 
	{
            System.out.println("Indices: " + res[0] + " and " + res[1]);
        } 
	else 
	{
            System.out.println("No two elements add up to the target.");
        }

        sc.close();
    }
}
