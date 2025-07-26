import java.util.*;

public class Rotate_List
{
    // Rotates the list to the left by 'pos' positions
    public static List<Integer> rotate(List<Integer> list, int pos)
    {
        int size = list.size();
        List<Integer> rotated = new ArrayList<>();

        for (int i = 0; i < size; i++)
        {
            rotated.add(list.get((i + pos) % size));
        }

        return rotated;
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

        System.out.print("Enter number of positions to rotate: ");
        int pos = sc.nextInt();

        // Normalize rotation count in case it's larger than list size
        pos = pos % n;

        List<Integer> rotatedList = rotate(numbers, pos);

        System.out.println("Rotated List: " + rotatedList);
    }
}
