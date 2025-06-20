import java.util.Scanner;

public class Que16 {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();

        int lengthWithoutMethod = findLength(input);
        int lengthWithMethod = input.length();

        System.out.println("Length calculated without using length() method: " + lengthWithoutMethod);
        System.out.println("Length calculated using length() method: " + lengthWithMethod);

        scanner.close();
    }
}
