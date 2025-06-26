import java.util.*;
class Fibonacci
{
    public static void generate(int n)
    {
        int a = 0, b = 1;
        System.out.print("Fibonacci sequence up to " + n + " terms: ");
        for (int i = 0; i < n; i++)
        {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms for Fibonacci sequence: ");
        int n = sc.nextInt();
        generate(n);
    }
}
