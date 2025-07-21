import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask how many sentences
        System.out.print("How many sentences will you enter? ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Clear the newline

        String[] sentences = new String[n];

        // Read sentences
        System.out.println("Enter " + n + " sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        // Read the word to search
        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();

        // Linear search
        boolean found = false;
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                System.out.println("Found in: " + sentence);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not Found");
        }

        scanner.close();
    }
}
