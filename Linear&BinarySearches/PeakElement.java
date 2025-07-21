import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: array size
        System.out.print("Enter size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input: array elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find peak element
        int peakIndex = findPeakElement(arr);

        // Output
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);

        scanner.close();
    }

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // or right
    }
}
