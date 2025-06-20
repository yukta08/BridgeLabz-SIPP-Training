import java.util.*;

public class Que18 {
    public static void main(String[] args) {
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = (int) (Math.random() * 9000) + 1000;
        }
        System.out.println("Numbers: " + Arrays.toString(nums));
        int min = nums[0], max = nums[0];
        double sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double avg = sum / nums.length;
        System.out.print(avg, min, max);
    }
}