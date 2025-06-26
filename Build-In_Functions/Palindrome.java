import java.util.*;
class Palindrome
{
    public static boolean check(String s)
    {
        int i = 0, j = s.length() - 1;
        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String str = sc.next();
        if(check(str))
        {
            System.out.println("The number "+str+" is a plindrome");
        }
        else
        {
            System.out.println("The number "+str+" is not a plindrome");
        }
    }
}
