import java.io.*;

public class FileCopy {

    public static void main(String[] args) {
        // Source and Destination File Paths
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        // FileInputStream and FileOutputStream declaration
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Attempt to open the source file
            File file = new File(sourceFile);
            if (!file.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            // Initialize streams
            fis = new FileInputStream(file);
            fos = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to " + destinationFile);

        } catch (IOException e) {
            System.out.println("An error occurred during file handling: " + e.getMessage());
        } finally {
            // Close streams in the finally block
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
}
