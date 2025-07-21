import java.io.*;

// ===== CLASS: File_Read_Performance =====
// Compares FileReader and InputStreamReader for large file reading
public class File_Read_Performance 
{
    // Read using FileReader (character-based)
    public static long readUsingFileReader(String path) throws IOException 
    {
        FileReader fr = new FileReader(path);
        long start = System.nanoTime();
        while (fr.read() != -1) {}
        long time = System.nanoTime() - start;
        fr.close();
        return time;
    }

    // Read using InputStreamReader (byte-to-character stream)
    public static long readUsingInputStreamReader(String path) throws IOException 
    {
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis);
        long start = System.nanoTime();
        while (isr.read() != -1) {}
        long time = System.nanoTime() - start;
        isr.close();
        return time;
    }

    public static void main(String[] args) 
    {
        try 
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter file path: ");
            String path = br.readLine();

            long t1 = readUsingFileReader(path);
            long t2 = readUsingInputStreamReader(path);

            System.out.println("\nFile Reading Performance:");
            System.out.println("FileReader         : " + t1 / 1_000_000.0 + " ms");
            System.out.println("InputStreamReader  : " + t2 / 1_000_000.0 + " ms");

        } 
        catch (IOException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
