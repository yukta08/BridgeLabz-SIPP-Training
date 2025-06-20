import java.util.Scanner;

public class Que26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextInt();

            if (heights[i] < 150 || heights[i] > 250) {
                System.out.println("Invalid height! Please enter a value between 150 and 250.");
                i--;
            }
        }

        int sum = 0, min = heights[0], max = heights[0];

        for (int height : heights) {
            sum += height;
            if (height < min)
                min = height;
            if (height > max)
                max = height;
        }

        double mean = (double) sum / heights.length;

        for (int h : heights) {
            System.out.print(h);

        }

        System.out.println("\nShortest height: " + min + " cms");
        System.out.println("Tallest height: " + max + " cms");
        System.out.printf("Mean height: %.2f cms\n", mean);

        sc.close();

    }
}
