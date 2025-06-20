import java.util.*;

public class Que6 {
    public static int FindNumberType(int number) {
        if (number > 0) {
            return 1;

        }
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int result = FindNumberType(number);
        System.out.println(result);

    }
}
