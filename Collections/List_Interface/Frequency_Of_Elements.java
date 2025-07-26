import java.util.*;

public class Frequency_Of_Elements
{
    // Count frequency of each string
    public static Map<String, Integer> countFrequency(List<String> list)
    {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String str : list)
        {
            if (freqMap.containsKey(str))
            {
                freqMap.put(str, freqMap.get(str) + 1);
            }
            else
            {
                freqMap.put(str, 1);
            }
        }
        return freqMap;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        System.out.println("Enter " + n + " words:");
        for (int i = 0; i < n; i++)
        {
            words.add(sc.nextLine());
        }

        Map<String, Integer> result = countFrequency(words);

        System.out.println("Frequency Map: " + result);
    }
}
