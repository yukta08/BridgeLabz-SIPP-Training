import java.util.*;

public class Que1 {
    public static int[] findRemainderAndQuotient(int NoOfChocolates, int noOfChildren) {
        int[] arr = new int[2];
        arr[0] = NoOfChocolates % noOfChildren; // Remaining chocolates
        arr[1] = NoOfChocolates / noOfChildren; // Chocolates per child
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of chocolates:");
        int NoOfChocolates = sc.nextInt();
        System.out.println("Enter the number of children:");
        int noOfChildren = sc.nextInt();

        int[] result = findRemainderAndQuotient(NoOfChocolates, noOfChildren);
        int chocolatesPerChild = result[1];
        int remainingChocolates = result[0];

        System.out.println(chocolatesPerChild);
        System.out.println(remainingChocolates);

        sc.close();
    }
}