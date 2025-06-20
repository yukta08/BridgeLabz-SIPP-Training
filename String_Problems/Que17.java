public class Que17 {
    public static int[] trimSpacesUsingCharAt(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end };
    }

    public static String substringUsingCharAt(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compareStringsUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String original = "   Hello, World!   ";

        int[] indices = trimSpacesUsingCharAt(original);

        String trimmedCustom = substringUsingCharAt(original, indices[0], indices[1]);

        String trimmedBuiltIn = original.trim();

        boolean isEqual = compareStringsUsingCharAt(trimmedCustom, trimmedBuiltIn);

        System.out.println("Original String: \"" + original + "\"");
        System.out.println("Trimmed using custom method: \"" + trimmedCustom + "\"");
        System.out.println("Trimmed using built-in trim(): \"" + trimmedBuiltIn + "\"");
        System.out.println("Are both trimmed strings equal? " + isEqual);
    }
}
