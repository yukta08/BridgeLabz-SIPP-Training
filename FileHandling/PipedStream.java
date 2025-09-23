import java.io.*;

public class PipedStream {

    public static void main(String[] args) {
        try {
            // Create piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect the streams

            // Writer Thread
            Thread writerThread = new Thread(() -> {
                try {
                    String message = "Hello from writer thread!";
                    pos.write(message.getBytes());
                    pos.close(); // Signal end of writing
                } catch (IOException e) {
                    System.out.println("Writer thread IOException: " + e.getMessage());
                }
            });

            // Reader Thread
            Thread readerThread = new Thread(() -> {
                try {
                    int data;
                    System.out.print("Reader received: ");
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Reader thread IOException: " + e.getMessage());
                }
            });

            // Start both threads
            writerThread.start();
            readerThread.start();

            // Wait for both to finish
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Main thread error: " + e.getMessage());
        }
    }
}
