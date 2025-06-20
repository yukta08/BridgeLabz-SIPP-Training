import java.util.Scanner;

public class Que13 {
    public static String[] splitIntoWords(String text) {
        int length = text.length();
        String[] tempWords = new String[length];
        int wordCount = 0;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    tempWords[wordCount++] = word.toString();
                    word.setLength(0);
                }
            }
        }

        if (word.length() > 0) {
            tempWords[wordCount++] = word.toString();
        }

        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = tempWords[i];
        }
        return words;
    }

    public static int stringLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        return count;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(stringLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordsWithLengths) {
        if (wordsWithLengths.length == 0) {
            return new int[] { -1, -1 };
        }
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLength = Integer.parseInt(wordsWithLengths[0][1]);
        int longestLength = shortestLength;

        for (int i = 1; i < wordsWithLengths.length; i++) {
            int len = Integer.parseInt(wordsWithLengths[i][1]);
            if (len < shortestLength) {
                shortestLength = len;
                shortestIndex = i;
            }
            if (len > longestLength) {
                longestLength = len;
                longestIndex = i;
            }
        }
        return new int[] { shortestIndex, longestIndex };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String inputText = scanner.nextLine();

        String[] words = splitIntoWords(inputText);
        String[][] wordsWithLengths = wordsWithLengths(words);
        int[] shortestAndLongest = findShortestAndLongest(wordsWithLengths);

        System.out.println("\nWords and their lengths:");
        System.out.printf("%-20s %-10s\n", "Word", "Length");
        for (String[] wl : wordsWithLengths) {
            System.out.printf("%-20s %-10s\n", wl[0], wl[1]);
        }

        if (shortestAndLongest[0] != -1) {
            System.out.println("\nShortest word: " + wordsWithLengths[shortestAndLongest[0]][0] +
                    " (Length: " + wordsWithLengths[shortestAndLongest[0]][1] + ")");
            System.out.println("Longest word: " + wordsWithLengths[shortestAndLongest[1]][0] +
                    " (Length: " + wordsWithLengths[shortestAndLongest[1]][1] + ")");
        } else {
            System.out.println("No words found in the input.");
        }

        scanner.close();
    }
}
