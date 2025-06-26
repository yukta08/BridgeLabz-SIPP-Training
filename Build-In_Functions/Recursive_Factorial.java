import java.util.*;
class Recursive_Factorial
{
    public static int factorial(int n)
    {
        if (n == 0 || n == 1) 
        {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int n = sc.nextInt();
        System.out.println("The factorial of " + n + " is: " + factorial(n));
    }
}
