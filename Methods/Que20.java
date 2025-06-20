import java.util.Scanner;

public class Que20 {

    public static void Number(int n) {
        if (n > 0) {
            System.out.print("positive");
        } else if (n < 0) {
            System.out.print("negative");
        } else {
            System.out.print("zero");
        }

    }

    public static void OddEven(int m) {
        if (m % 2 == 0) {
            System.out.print("even");
        } else {
            System.out.print("odd");
        }
    }

    public static int comparison(int o, int p) {
        if (o > p) {
            return 1;
        } else if (o < p) {
            return -1;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int o = sc.nextInt();
        int p = sc.nextInt();
        Number(n);
        OddEven(m);
        int result = comparison(o, p);

        if (result == 1) {
            System.out.println("Greater");
        } else if (result == -1) {
            System.out.println("Lesser");
        } else {
            System.out.println("Equal");
        }

    }

}
