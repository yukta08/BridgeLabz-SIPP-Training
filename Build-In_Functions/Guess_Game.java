import java.util.*;

class Guess_Game 
{
    public static int getGuess(int low, int high) 
    {
        return low + (high - low) / 2;
    }

    public static String getFeedback(int guess, int actual) 
    {
        if (guess < actual) 
        {
            return "low";
        }
        else if (guess > actual) 
        {
            return "high";
        }
        return "correct";
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Think of a number between 1 and 100 (secret input): ");
        int number = sc.nextInt();
        int low = 1, high = 100;
        int attempts = 0;
        while (low <= high) 
        {
            int guess = getGuess(low, high);
            String feedback = getFeedback(guess, number);
            attempts++;
            System.out.println("Computer guesses: " + guess);
            if (feedback.equals("correct")) 
            {
                System.out.println("Correct! Guessed in " + attempts + " attempts.");
                break;
            } 
            else if (feedback.equals("low")) 
            {
                low = guess + 1;
            } 
            else 
            {
                high = guess - 1;
            }
        }
    }
}
