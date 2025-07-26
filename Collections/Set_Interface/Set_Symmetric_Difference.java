import java.util.*;

public class Set_Symmetric_Difference
{
    // Returns elements in either set but not in both
    public static Set<Integer> getSymmetricDifference(Set<Integer> set1, Set<Integer> set2)
    {
        Set<Integer> result = new HashSet<>(set1);     // Add all from set1
        result.addAll(set2);                           // Add all from set2

        Set<Integer> common = new HashSet<>(set1);     // Copy of set1
        common.retainAll(set2);                        // Keep only common elements

        result.removeAll(common);                      // Remove common elements
        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.print("Enter number of elements in Set 1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter " + n1 + " elements:");
        for (int i = 0; i < n1; i++)
        {
            set1.add(sc.nextInt());
        }

        System.out.print("Enter number of elements in Set 2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter " + n2 + " elements:");
        for (int i = 0; i < n2; i++)
        {
            set2.add(sc.nextInt());
        }

        Set<Integer> symmetricDifference = getSymmetricDifference(set1, set2);

        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
