import java.util.*;

public class Set_Union_Intersection
{
    // Computes union of two sets
    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2)
    {
        Set<Integer> union = new HashSet<>(set1);  // Copy of set1
        union.addAll(set2);                        // Add elements of set2
        return union;
    }

    // Computes intersection of two sets
    public static Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2)
    {
        Set<Integer> intersection = new HashSet<>(set1);  // Copy of set1
        intersection.retainAll(set2);                     // Keep only common elements
        return intersection;
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

        Set<Integer> union = getUnion(set1, set2);
        Set<Integer> intersection = getIntersection(set1, set2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}
