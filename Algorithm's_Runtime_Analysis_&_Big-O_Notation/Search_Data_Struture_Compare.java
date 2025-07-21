import java.util.*;

// ===== CLASS: Search_Datat_Struture_Compare =====
// Compares Array, HashSet, and TreeSet performance for element search
public class Search_Data_Struture_Compare 
{
    // Search in array using linear search
    public static boolean linearSearch(int[] arr, int key) 
    {
        for (int val : arr) 
        {
            if (val == key) return true;
        }
        return false;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dataset size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) 
        {
            int val = rand.nextInt(n * 10);
            arr[i] = val;
            hashSet.add(val);
            treeSet.add(val);
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        long start, time;

        // Linear search in array
        start = System.nanoTime();
        boolean foundArray = linearSearch(arr, key);
        time = System.nanoTime() - start;
        System.out.println("Array Found: " + foundArray + ", Time: " + time / 1_000_000.0 + " ms");

        // Search in HashSet
        start = System.nanoTime();
        boolean foundHash = hashSet.contains(key);
        time = System.nanoTime() - start;
        System.out.println("HashSet Found: " + foundHash + ", Time: " + time / 1_000_000.0 + " ms");

        // Search in TreeSet
        start = System.nanoTime();
        boolean foundTree = treeSet.contains(key);
        time = System.nanoTime() - start;
        System.out.println("TreeSet Found: " + foundTree + ", Time: " + time / 1_000_000.0 + " ms");

        sc.close();
    }
}
