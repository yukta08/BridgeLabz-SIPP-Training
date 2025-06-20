import java.util.Scanner;

public class Que11 {
    public static double calculateWindChill(double temp, double windSpeed) {
        return 35.74 + 0.6215 * temp - 35.75 * Math.pow(windSpeed, 0.16) + 0.4275 * temp * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temperature = sc.nextDouble();
        double windSpeed = sc.nextDouble();

        double windChill = calculateWindChill(temperature, windSpeed);

        System.out.println("Wind Chill Temperature: " + windChill);
    }
}