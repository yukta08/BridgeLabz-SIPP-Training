import java.util.Scanner;

public class MatrixBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Matrix dimensions
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        // Matrix elements input
        System.out.println("Enter the matrix elements (row-wise sorted, strictly increasing):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Target value
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        // Perform search
        boolean found = searchMatrix(matrix, target);
        System.out.println("Target found? " + found);

        scanner.close();
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / cols;
            int col = mid % cols;

            int midVal = matrix[row][col];

            if (midVal == target)
                return true;
            else if (midVal < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }
}
