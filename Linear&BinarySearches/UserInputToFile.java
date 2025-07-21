import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String outputFile = "user_input.txt";  // File to save input

        try {
            // Reading from console
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(isr);

            // Writing to file
            FileWriter writer = new FileWriter(outputFile);

            System.out.println("Enter text (type 'exit' to finish):");

            String line;
            while (true) {
                line = reader.readLine();  // Read input line
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line + System.lineSeparator());  // Write to file
            }

            // Close all resources
            writer.close();
            reader.close();
            isr.close();

            System.out.println("User input saved to " + outputFile);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
