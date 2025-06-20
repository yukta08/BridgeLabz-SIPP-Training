import java.util.*;

public class Que7 {

    public static int findMaximumHandshakes(int numberOfStudents) {
        int result = (numberOfStudents * (numberOfStudents - 1)) / 2;
        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        int result = findMaximumHandshakes(numberOfStudents);
        System.out.println(result);

    }
}
