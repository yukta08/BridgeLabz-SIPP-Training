import java.util.Random;

public class Que27 {
    public static void main(String[] args) {
        int size = 3;
        int[][] A = randMatrix(size), B = randMatrix(size);

        System.out.println("A:");
        print(A);
        System.out.println("\nB:");
        print(B);

        System.out.println("\nA+B:");
        print(add(A, B));
        System.out.println("\nA-B:");
        print(subtract(A, B));
        System.out.println("\nA*B:");
        print(multiply(A, B));
    }

    static int[][] randMatrix(int n) {
        Random r = new Random();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                m[i][j] = 1 + r.nextInt(10);
        return m;
    }

    static void print(int[][] m) {
        for (int[] row : m) {
            for (int c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    static int[][] add(int[][] a, int[][] b) {
        int n = a.length;
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                r[i][j] = a[i][j] + b[i][j];
        return r;
    }

    static int[][] subtract(int[][] a, int[][] b) {
        int n = a.length;
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                r[i][j] = a[i][j] - b[i][j];
        return r;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    r[i][j] += a[i][k] * b[k][j];
        return r;
    }
}