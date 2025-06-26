import java.util.*;
class Maximum_Three
{
    public static int max(int a, int b, int c)
    {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enetr First number: ");
        int a = sc.nextInt();
        System.out.println("Enetr Second number: ");
        int b = sc.nextInt();
        System.out.println("Enetr Third number: ");
        int c = sc.nextInt();
        System.out.println("Largest among the three number is: "+max(a, b, c));
    }
}
