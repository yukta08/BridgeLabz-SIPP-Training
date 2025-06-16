import java.util.Scanner;

public class Question20 {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter age and height of Amar: ");
        int age1 = scanner.nextInt();
        int height1 = scanner.nextInt();

        System.out.print("Enter age and height of Akbar: ");
        int age2 = scanner.nextInt();
        int height2 = scanner.nextInt();

        System.out.print("Enter age and height of Anthony: ");
        int age3 = scanner.nextInt();
        int height3 = scanner.nextInt();

        String youngest = (age1 <= age2 && age1 <= age3) ? "Amar"
                        : (age2 <= age1 && age2 <= age3) ? "Akbar" : "Anthony";

        String tallest = (height1 >= height2 && height1 >= height3) ? "Amar"
                       : (height2 >= height1 && height2 >= height3) ? "Akbar" : "Anthony";

        System.out.println("Youngest: " + youngest);
        System.out.println("Tallest: " + tallest);

        scanner.close();
}
}
