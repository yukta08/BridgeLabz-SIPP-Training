import java.util.*;

public class Set_To_Sorted_List
{
    public static List<Integer> convertAndSort(Set<Integer> set)
    {
        List<Integer> list = new ArrayList<>(set); // Convert Set to List
        Collections.sort(list);                    // Sort in ascending order
        return list;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Set<Integer> inputSet = new HashSet<>();

        System.out.print("Enter number of elements in the set: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++)
        {
            inputSet.add(sc.nextInt());
        }

        List<Integer> sortedList = convertAndSort(inputSet);

        System.out.println("Sorted List: " + sortedList);
    }
}
