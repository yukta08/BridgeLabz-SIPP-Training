import java.util.*;
class Gcd_Lcm
{
    public static int gcd(int a, int b)
    {
        if (b == 0) 
        {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b)
    {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int x = sc.nextInt();
        System.out.print("Enter the second number: ");
        int y = sc.nextInt();
        System.out.println("GCD of " + x + " and " + y + " is: " + gcd(x, y));
        System.out.println("LCM of " + x + " and " + y + " is: " + lcm(x, y));
    }
}
