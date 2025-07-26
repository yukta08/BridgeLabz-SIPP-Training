import java.util.*;

class Max_Value_Key_Finder
{
    public static String findMaxKey(Map<String, Integer> map)
    {
        String maxKey  = null;
        int    maxVal  = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            String key = entry.getKey();
            int    val = entry.getValue();

            if (val > maxVal)
            {
                maxVal = val;
                maxKey = key;
            }
        }

        return maxKey;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of key-value pairs: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++)
        {
            System.out.print("Enter key #" + i + ": ");
            String key = sc.next();

            System.out.print("Enter value for \"" + key + "\": ");
            int value = sc.nextInt();

            map.put(key, value);
        }

        String result = findMaxKey(map);

        System.out.println("Key with Maximum Value: " + result);

        sc.close();
    }
}
