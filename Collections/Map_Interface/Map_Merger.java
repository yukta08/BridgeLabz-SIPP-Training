import java.util.*;

class Map_Merger
{
    // Merges two maps by summing values for common keys
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1,
                                                 Map<String, Integer> map2)
    {
        Map<String, Integer> result = new HashMap<>(map1); // Start with map1

        for (Map.Entry<String, Integer> entry : map2.entrySet())
        {
            String key = entry.getKey();
            int value  = entry.getValue();

            result.put(key, result.getOrDefault(key, 0) + value);
        }

        return result;
    }

    // Reads a map from user input
    public static Map<String, Integer> readMap(Scanner sc, String mapName)
    {
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of entries for " + mapName + ": ");
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

        // Read both maps from user
        Map<String, Integer> map1 = readMap(sc, "Map1");
        Map<String, Integer> map2 = readMap(sc, "Map2");

        // Merge and print result
        Map<String, Integer> merged = mergeMaps(map1, map2);

        System.out.println("Merged Map: " + merged);

        sc.close();
    }
}
