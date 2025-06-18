import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }

        int youngIndex = 0;
        int tallIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngIndex])
                youngIndex = i;
            if (height[i] > height[tallIndex])
                tallIndex = i;
        }

        System.out.println("Youngest: Friend " + (youngIndex + 1));
        System.out.println("Tallest: Friend " + (tallIndex + 1));
    }
}