import java.util.Scanner;

public class Que20 {

    public static String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }


    public static String[][] findCharTypes(String str) {
        int length = str.length();
        String[][] result = new String[length][2];
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            result[i][0] = Character.toString(ch);
            result[i][1] = checkCharType(ch);
        }
        return result;
    }

    public static void displayCharTypes(String[][] arr) {
        System.out.printf("%-10s %-15s%n", "Character", "Character Type");
        System.out.println("---------------------------");
        for (String[] row : arr) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }
s
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] charTypes = findCharTypes(input);
        displayCharTypes(charTypes);

        scanner.close();
    }
}
