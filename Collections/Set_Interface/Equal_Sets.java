import java.util.*;

public class Equal_Sets
{
    // Compare two sets for equality
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2)
    {
        return set1.equals(set2);
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

        boolean result = areSetsEqual(set1, set2);
        System.out.println("Are both sets equal? " + result);
    }
}
