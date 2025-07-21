import java.util.*;

// ===== CLASS: String_Concat_Performance =====
// Compares String, StringBuilder, and StringBuffer concatenation speed
public class String_Concat_Performance 
{
    // Concatenate using String (Immutable, inefficient)
    public static long testString(int n) 
    {
        String s = "";
        long start = System.nanoTime();
        for (int i = 0; i < n; i++)
            s += "a";
        return System.nanoTime() - start;
    }

    // Concatenate using StringBuilder (Mutable, fast, single-threaded)
    public static long testBuilder(int n) 
    {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++)
            sb.append("a");
        return System.nanoTime() - start;
    }

    // Concatenate using StringBuffer (Mutable, thread-safe)
    public static long testBuffer(int n) 
    {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++)
            sb.append("a");
        return System.nanoTime() - start;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of concatenations: ");
        int n = sc.nextInt();

        long t1 = testString(n);
        long t2 = testBuilder(n);
        long t3 = testBuffer(n);

        System.out.println("\nConcatenation Performance:");
        System.out.println("String       : " + t1 / 1_000_000.0 + " ms");
        System.out.println("StringBuilder: " + t2 / 1_000_000.0 + " ms");
        System.out.println("StringBuffer : " + t3 / 1_000_000.0 + " ms");

        sc.close();
    }
}
