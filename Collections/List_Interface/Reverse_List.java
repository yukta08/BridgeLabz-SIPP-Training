import java.util.*;

public class Reverse_List
{
    // Reverse ArrayList manually
    public static List<Integer> reverseArrayList(List<Integer> list)
    {
        List<Integer> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--)
        {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    // Reverse LinkedList manually
    public static List<Integer> reverseLinkedList(List<Integer> list)
    {
        List<Integer> reversed = new LinkedList<>();
        ListIterator<Integer> it = list.listIterator(list.size());
        while (it.hasPrevious())
        {
            reversed.add(it.previous());
        }
        return reversed;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++)
        {
            int val = sc.nextInt();
            arrayList.add(val);
            linkedList.add(val);
        }

        // Reverse and display
        List<Integer> reversedArrayList = reverseArrayList(arrayList);
        List<Integer> reversedLinkedList = reverseLinkedList(linkedList);

        System.out.println("Reversed ArrayList: " + reversedArrayList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}
