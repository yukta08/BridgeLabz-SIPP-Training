import java.util.Scanner;

public class LargestTwoDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int maxDigits = 10;
        int[] digits = new int[maxDigits];
        int index = 0;

        while (number != 0) {
            if (index == maxDigits) {
                maxDigits *= 2;
                int[] temp = new int[maxDigits];
                for (int i = 0; i < index; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }
            digits[index++] = number % 10;
            number /= 10;
        }

        int largest = 0, second = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                second = largest;
                largest = digits[i];
            } else if (digits[i] > second && digits[i] != largest) {
                second = digits[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + second);
    }
}
