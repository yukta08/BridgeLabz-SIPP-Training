import java.util.*;

public class Que9 {

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        // This will throw NumberFormatException if text is not a valid integer
        int num = Integer.parseInt(text);
        System.out.println("Parsed number: " + num);
    }

    // Method to handle NumberFormatException and generic RuntimeException
    public static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to parse as integer:");
        String input = sc.nextLine();

        // Call method that generates exception (will cause program to crash if not
        // handled)
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception generated: " + e.getMessage());
        }

        // Call method that handles exception gracefully
        handleException(input);
    }
}
