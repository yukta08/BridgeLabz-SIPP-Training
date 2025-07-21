public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] words = {"Java", " is", " awesome!"};
        String result = concatenateStrings(words);
        System.out.println("Concatenated String: " + result);
    }

    public static String concatenateStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();
        
        for (String word : arr) {
            sb.append(word);
        }

        return sb.toString();
    }
}
