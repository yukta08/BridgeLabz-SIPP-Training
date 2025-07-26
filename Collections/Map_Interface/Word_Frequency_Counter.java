import java.io.*;
import java.util.*;

class Word_Frequency_Counter
{
    public static Map<String, Integer> countWords(String fileName)
    {
        Map<String, Integer> freqMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;

            while ((line = br.readLine()) != null)
            {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

                String[] words = line.split("\\s+");

                for (String word : words)
                {
                    if (!word.isEmpty())
                    {
                        freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return freqMap;
    }

    public static void main(String[] args)
    {
        // Sample input text (for demonstration)
        String fileName = "input.txt";

        Map<String, Integer> result = countWords(fileName);

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : result.entrySet())
        {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
