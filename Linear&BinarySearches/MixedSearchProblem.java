import java.util.Arrays;
import java.util.Scanner;

public class MixedSearchProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: array size and elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Part 1: First Missing Positive Integer
        int missing = findFirstMissingPositive(nums.clone());
        System.out.println("First missing positive integer: " + missing);

        // Part 2: Binary Search for target
        System.out.print("Enter target number to search: ");
        int target = sc.nextInt();

        Arrays.sort(nums);
        int index = binarySearch(nums, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index (in sorted array): " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }

        sc.close();
    }

    // Part 1: Find first missing positive integer
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] and arr[arr[i] - 1]
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Part 2: Binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
