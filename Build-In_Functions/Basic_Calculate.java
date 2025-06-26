import java.util.*;
class Basic_Calculate
{
    public static int add(int a, int b) 
    { 
        return a + b; 
    }
    public static int sub(int a, int b) 
    { 
        return a - b; 
    }
    public static int mul(int a, int b) 
    { 
        return a * b; 
    }
    public static int div(int a, int b) 
    { 
        return a / b; 
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.print("Enter operation (+, -, *, /): ");
        String op = sc.next();
        if (op.equals("+")) 
        {
            System.out.println("Result: " + add(a, b));
        }
        else if (op.equals("-")) 
        {
            System.out.println("Result: " + sub(a, b));
        }
        else if (op.equals("*")) 
        {
            System.out.println("Result: " + mul(a, b));
        }
        else if (op.equals("/")) 
        {
            System.out.println("Result: " + div(a, b));
        }
        else 
        {
            System.out.println("Invalid operation");
        }
    }
}
