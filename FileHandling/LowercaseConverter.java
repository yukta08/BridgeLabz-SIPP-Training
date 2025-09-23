import java.io.*;

public class UppercaseToLowercaseConverter {

    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        try (
            InputStreamReader reader = new InputStreamReader(new FileInputStream(sourceFile), "UTF-8");
            BufferedReader br = new BufferedReader(reader);

            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(destinationFile), "UTF-8");
            BufferedWriter bw = new BufferedWriter(writer)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine(); // Preserve original line breaks
            }

            System.out.println("File converted to lowercase and written to: " + destinationFile);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
