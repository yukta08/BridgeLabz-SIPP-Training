import java.io.*;

public class ErrorLogReader {

    public static void main(String[] args) {
        String filePath = "large_log_file.txt"; // Replace with your actual file path

        try (
            BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
