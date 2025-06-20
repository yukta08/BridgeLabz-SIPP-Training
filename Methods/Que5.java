
import java.util.*;

public class Que5 {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int[] arr = new int[3];
        arr[0] = number1;
        arr[1] = number2;
        arr[2] = number3;

        Arrays.sort(arr);

        int smallest = arr[0];
        int largest = arr[2];

        return new int[] { smallest, largest };

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        int[] result = findSmallestAndLargest(number1, number2, number3);

        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);

    }
}
