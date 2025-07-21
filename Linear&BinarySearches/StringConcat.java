public class StringConcat {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // Using StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuffer.append(text);
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        // Using StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append(text);
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // Output results
        System.out.println("Time taken by StringBuffer  : " + (bufferTime / 1_000_000) + " ms");
        System.out.println("Time taken by StringBuilder: " + (builderTime / 1_000_000) + " ms");
    }
}
