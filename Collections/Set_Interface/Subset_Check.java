import java.util.*;

public class Subset_Check
{
    public static boolean isSubset(Set<Integer> small, Set<Integer> big)
    {
        return big.containsAll(small); // Checks if all elements in 'small' exist in 'big'
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.print("Enter number of elements in Set1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of Set1:");
        for (int i = 0; i < n1; i++)
        {
            set1.add(sc.nextInt());
        }

        System.out.print("Enter number of elements in Set2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of Set2:");
        for (int i = 0; i < n2; i++)
        {
            set2.add(sc.nextInt());
        }

        boolean result = isSubset(set1, set2);
        System.out.println("Is Set1 a subset of Set2? " + result);
    }
}
