import java.text.*;
import java.util.*;

public class Date_Format
{
    public static void main(String[] args) 
    {
        Date date = new Date();
        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat f3 = new SimpleDateFormat("EEE, MMM dd, yyyy");

        System.out.println("Current Date in Different Formats:");
        System.out.println("Format 1 (dd/MM/yyyy): " + f1.format(date));
        System.out.println("Format 2 (yyyy-MM-dd): " + f2.format(date));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + f3.format(date));
    }
}
