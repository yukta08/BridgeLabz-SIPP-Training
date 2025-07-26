import java.util.*;

class Map_Inverter
{
    // Inverts a map of <String, Integer> into <Integer, List<String>>
    public static Map<Integer, List<String>> invert(Map<String, Integer> map)
    {
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            String  key    = entry.getKey();
            Integer value  = entry.getValue();

            inverted.putIfAbsent(value, new ArrayList<>());
            inverted.get(value).add(key);
        }

        return inverted;
    }

    // Reads a string->int map from user input
    public static Map<String, Integer> readMap(Scanner sc)
    {
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of key-value pairs: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter key #" + (i + 1) + ": ");
            String key = sc.next();

            System.out.print("Enter value for key \"" + key + "\": ");
            int value = sc.nextInt();

            map.put(key, value);
        }

        return map;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> original = readMap(sc);

        System.out.println("Original Map: " + original);

        Map<Integer, List<String>> result = invert(original);

        System.out.println("Inverted Map: " + result);

        sc.close();
    }
}
