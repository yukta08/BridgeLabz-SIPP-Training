import java.util.*;

public class Que4 {

    // Method to return characters in a string without using toCharArray instance
    // method and require a class require a obj
    public char[] getCharacters(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = sc.next();

        Que4 obj = new Que4();
        char[] customChars = obj.getCharacters(input);
        char[] builtInChars = input.toCharArray();

        boolean isEqual = compareCharArrays(customChars, builtInChars);

        System.out.println("Custom char array: " + Arrays.toString(customChars));
        System.out.println("Built-in char array: " + Arrays.toString(builtInChars));
        System.out.println("Are both char arrays equal? " + isEqual);
    }
}
