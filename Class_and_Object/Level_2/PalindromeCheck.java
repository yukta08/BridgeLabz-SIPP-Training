import java.util.*;

// Class to check if a string is a palindrome
class PalindromeChecker 
{
    String text;  // Input text to check

    // Method to accept input from user
    void getInput(Scanner sc) 
    {
        System.out.print("Enter a string: ");
        text = sc.nextLine();
    }

    // Method to check if the text is a palindrome
    boolean isPalindrome() 
    {
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) 
	{
            if (cleaned.charAt(left) != cleaned.charAt(right)) 
	    {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to display the result
    void displayResult() 
    {
        if (isPalindrome()) 
	{
            System.out.println("\"" + text + "\" is a palindrome.");
        } 
	else 
	{
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}

// Main class to run the program
public class PalindromeCheck 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        PalindromeChecker pc = new PalindromeChecker();
        pc.getInput(sc);
        pc.displayResult();
    }
}
