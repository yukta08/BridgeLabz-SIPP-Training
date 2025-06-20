import java.util.Scanner;

public class Que25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coordinates for point A (x1 y1):");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.println("Enter coordinates for point B (x2 y2):");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        System.out.println("Enter coordinates for point C (x3 y3):");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        boolean collinearSlope = checkCollinearSlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear using slope formula: " + collinearSlope);

        boolean collinearArea = checkCollinearArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Collinear using area formula: " + collinearArea);

        sc.close();
    }

    public static boolean checkCollinearSlope(double x1, double y1, double x2, double y2, double x3, double y3) {

        if (x2 - x1 == 0 && x3 - x1 == 0) {
            return true;
        }
        if (x2 - x1 == 0 || x3 - x1 == 0) {
            return false;
        }
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeAC = (y3 - y1) / (x3 - x1);
        return slopeAB == slopeAC;
    }

    public static boolean checkCollinearArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }
}