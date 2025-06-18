import java.util.Scanner;

public class Table6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] table = new int[4][10];
        for (int i = 6; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                table[i - 6][j - 1] = i * j;
            }
        }
        for (int i = 6; i <= 9; i++) {
            System.out.println("Table of " + i);
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + table[i - 6][j - 1]);
            }
        }
    }
}