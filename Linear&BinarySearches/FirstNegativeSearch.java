public class FirstNegativeSearch {
    public static void main(String[] args) {
        int[] nums = {5, 8, 12, 0, -7, 3, -2};  // Test array
        int index = findFirstNegative(nums);
        
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;  // Return index of first negative number
            }
        }
        return -1;  // No negative number found
    }
}
