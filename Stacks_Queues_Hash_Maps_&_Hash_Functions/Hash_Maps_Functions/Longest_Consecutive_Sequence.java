import java.util.*;

public class Longest_Consecutive_Sequence 
{

    // Find length of longest consecutive sequence
    public int findLongest(int[] arr) 
    {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) 
	{
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) 
	{
            // Start only from the beginning of a sequence
            if (!set.contains(num - 1)) 
	    {
                int curr = num;
                int count = 1;

                while (set.contains(curr + 1)) 
		{
                    curr++;
                    count++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Longest_Consecutive_Sequence lcs = new Longest_Consecutive_Sequence();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
	{
            arr[i] = sc.nextInt();
        }

        int result = lcs.findLongest(arr);
        System.out.println("Length of longest consecutive sequence: " + result);

        sc.close();
    }
}
