import java.util.*;

public class Que13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[3];
        int[] heights = new int[3];

        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }

        int minAgeIndex = 0, maxHeightIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[minAgeIndex])
                minAgeIndex = i;
            if (heights[i] > heights[maxHeightIndex])
                maxHeightIndex = i;
        }

        System.out.println("Youngest age: " + ages[minAgeIndex]);
        System.out.println("Tallest height: " + heights[maxHeightIndex]);

        sc.close();
    }
}