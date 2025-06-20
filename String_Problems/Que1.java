import java.util.*;

public class Que1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();

        if (n.charAt(0) == m.charAt(0)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        if (n.equals(m)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}