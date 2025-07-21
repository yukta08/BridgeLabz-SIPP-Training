import java.io.*;

public class StringAndFile {
    public static void main(String[] args) throws IOException {
        int iterations = 1_000_000;
        String word = "hello";
        String filePath = "100MB.txt";  // Replace with your large file path

        // PART 1: StringBuilder Performance
        long startBuilder = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append(word);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = (endBuilder - startBuilder) / 1_000_000;

        // PART 1: StringBuffer Performance
        long startBuffer = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuffer.append(word);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = (endBuffer - startBuffer) / 1_000_000;

        System.out.println("=== String Concatenation Performance ===");
        System.out.println("StringBuilder Time: " + timeBuilder + " ms");
        System.out.println("StringBuffer Time : " + timeBuffer + " ms");

        // PART 2: FileReader - Word Count
        long startFileReader = System.nanoTime();
        int wordCountFR = countWordsWithFileReader(filePath);
        long endFileReader = System.nanoTime();
        long timeFR = (endFileReader - startFileReader) / 1_000_000;

        // PART 2: InputStreamReader - Word Count
        long startISR = System.nanoTime();
        int wordCountISR = countWordsWithInputStreamReader(filePath);
        long endISR = System.nanoTime();
        long timeISR = (endISR - startISR) / 1_000_000;

        System.out.println("\n=== File Reading Performance ===");
        System.out.println("FileReader Word Count        : " + wordCountFR);
        System.out.println("FileReader Time              : " + timeFR + " ms");
        System.out.println("InputStreamReader Word Count : " + wordCountISR);
        System.out.println("InputStreamReader Time       : " + timeISR + " ms");
    }

    // Method using FileReader
    public static int countWordsWithFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            if (!line.isBlank()) {
                count += words.length;
            }
        }
        br.close();
        return count;
    }

    // Method using InputStreamReader
    public static int countWordsWithInputStreamReader(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.trim().split("\\s+");
            if (!line.isBlank()) {
                count += words.length;
            }
        }
        br.close();
        return count;
    }
}
