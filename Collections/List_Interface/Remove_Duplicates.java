import java.util.*;

public class Remove_Duplicates
{
    // Removes duplicates while maintaining insertion order
    public static List<Integer> removeDuplicates(List<Integer> list)
    {
        Set<Integer> seen = new LinkedHashSet<>();

        for (int num : list)
        {
            seen.add(num);
        }

        return new ArrayList<>(seen);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++)
        {
            numbers.add(sc.nextInt());
        }

        List<Integer> result = removeDuplicates(numbers);

        System.out.println("List after removing duplicates: " + result);
    }
}
