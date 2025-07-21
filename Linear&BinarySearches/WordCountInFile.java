import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Replace with the path to your file
        String targetWord = "Java";      // The word to count
        int count = 0;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                // Split line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equals(targetWord)) { // Case-sensitive match
                        count++;
                    }
                }
            }

            br.close();
            fr.close();

            System.out.println("The word '" + targetWord + "' appeared " + count + " times.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
