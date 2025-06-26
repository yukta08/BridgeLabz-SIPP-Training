import java.util.*;
class Temp_Convert
{
    public static double toF(double c)
    {
        return (c * 9 / 5) + 32;
    }

    public static double toC(double f)
    {
        return (f - 32) * 5 / 9;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double c = sc.nextDouble();
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.println("The Celsius " + c + " is " + toF(c) + " Fahrenheit");
        System.out.println("The Fahrenheit " + f + " is " + toC(f) + " Celsius");
    }
}
