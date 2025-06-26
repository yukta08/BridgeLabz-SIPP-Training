import java.util.*;
import java.time.*;

class Date_Arithmetic
{
    public static LocalDate calculate(LocalDate date)
    {
        date = date.plusDays(7);
        date = date.plusMonths(1);
        date = date.plusYears(2);
        date = date.minusWeeks(3);
        return date;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input);
        LocalDate result = calculate(date);
        System.out.println("The final date after calculations is: " + result);
    }
}
