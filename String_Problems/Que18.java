import java.util.Scanner;

public class Que18 {

    public static int lengthOfString(String s) {
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

    public static String[] splitText(String s) {
        int length = lengthOfString(s);
        int wordCount = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;
        int[] spaceIndexes = new int[wordCount - 1];
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }
        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            int end;
            if (i == wordCount - 1) {
                end = length;
            } else {
                end = spaceIndexes[i];
            }
            StringBuilder word = new StringBuilder();
            for (int j = start; j < end; j++) {
                word.append(s.charAt(j));
            }
            words[i] = word.toString();
            start = end + 1;
        }
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1 == null || arr2 == null)
            return false;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String input = sc.nextLine();
        String[] userSplit = splitText(input);
        String[] builtInSplit = input.split(" ");

        boolean result = compareArrays(userSplit, builtInSplit);

        System.out.println("User-defined split result:");
        for (String word : userSplit) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in split result:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("\nAre both splits equal? " + result);

        sc.close();
    }
}
