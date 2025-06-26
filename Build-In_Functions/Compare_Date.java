import java.util.*;
import java.time.*;

class Compare_date
{
    public static String compareDates(LocalDate d1, LocalDate d2)
    {
        if (d1.isBefore(d2)) 
        {
            return "First date is before second date";
        }
        if (d1.isAfter(d2)) 
        {
            return "First date is after second date";
        }
        return "Both dates are the same";
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String s1 = sc.nextLine();
        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String s2 = sc.nextLine();
        LocalDate date1 = LocalDate.parse(s1);
        LocalDate date2 = LocalDate.parse(s2);
        String result = compareDates(date1, date2);
        System.out.println("Comparison result: " + result);
    }
}
