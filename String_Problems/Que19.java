import java.util.Scanner;

public class Que19 {

    public static String[] splitText(String text) {
        int n = text.length();

        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c != ' ' && !inWord) {
                inWord = true;
                wordCount++;
            } else if (c == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder sb = new StringBuilder();
        inWord = false;
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                sb.append(c);
                inWord = true;
            } else {
                if (inWord) {
                    words[wordIndex++] = sb.toString();
                    sb = new StringBuilder();
                    inWord = false;
                }
            }
        }
        if (inWord) {
            words[wordIndex] = sb.toString();
        }
        return words;
    }

    public static int stringLength(String s) {
        int length = 0;
        try {
            while (true) {
                s.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return length;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(stringLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String input = sc.nextLine();

        String[] words = splitText(input);
        String[][] wordLengths = wordsWithLengths(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < wordLengths.length; i++) {
            String word = wordLengths[i][0];
            int length = Integer.parseInt(wordLengths[i][1]);
            System.out.println(word + "\t" + length);
        }
        sc.close();
    }
}
