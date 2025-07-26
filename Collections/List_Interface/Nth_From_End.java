import java.util.*;

public class Nth_From_End
{
    // Returns the Nth element from end without computing size
    public static String findNthFromEnd(LinkedList<String> list, int n)
    {
        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        // Advance the fast pointer by n steps
        for (int i = 0; i < n; i++)
        {
            if (!fast.hasNext())
            {
                return "Invalid N (greater than list size)";
            }
            fast.next();
        }

        // Move both pointers until fast reaches end
        while (fast.hasNext())
        {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> data = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter " + count + " strings:");
        for (int i = 0; i < count; i++)
        {
            data.add(sc.nextLine());
        }

        System.out.print("Enter N (position from end): ");
        int n = sc.nextInt();

        String result = findNthFromEnd(data, n);

        System.out.println("Nth element from end: " + result);
    }
}
