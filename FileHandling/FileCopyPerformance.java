import java.io.*;

public class FileCopyPerformance {

    private static final int BUFFER_SIZE = 4096; // 4KB

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";         // Replace with actual file
        String unbufferedDest = "copy_unbuffered.dat";
        String bufferedDest = "copy_buffered.dat";

        System.out.println("Starting file copy comparisons...\n");

        // Unbuffered copy
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, unbufferedDest);
        System.out.println("Unbuffered Copy Time: " + unbufferedTime + " ns");

        // Buffered copy
        long bufferedTime = copyUsingBufferedStreams(sourceFile, bufferedDest);
        System.out.println("Buffered Copy Time:   " + bufferedTime + " ns");

        // Time difference
        long diff = unbufferedTime - bufferedTime;
        System.out.println("\nBuffered streams were faster by: " + diff + " ns");
    }

    // Method 1: Using unbuffered streams
    public static long copyUsingUnbufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during unbuffered copy: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }

    // Method 2: Using buffered streams
    public static long copyUsingBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error during buffered copy: " + e.getMessage());
        }

        return System.nanoTime() - startTime;
    }
}
