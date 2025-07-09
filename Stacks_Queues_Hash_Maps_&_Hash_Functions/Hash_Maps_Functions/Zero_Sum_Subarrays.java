import java.util.*;

public class Zero_Sum_Subarrays 
{

    // Find and print all subarrays with zero sum
    public void findZeroSumSubarrays(int[] arr) 
    {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Initialize map with sum 0 at index -1
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) 
	{
            sum += arr[i];

            if (sumMap.containsKey(sum)) 
	    {
                for (int start : sumMap.get(sum)) 
		{
                    System.out.println("Subarray: [" + (start + 1) + " to " + i + "]");
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Zero_Sum_Subarrays zs = new Zero_Sum_Subarrays();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) 
	{
            arr[i] = sc.nextInt();
        }

        System.out.println("Zero-sum subarrays:");
        zs.findZeroSumSubarrays(arr);

        sc.close();
    }
}
