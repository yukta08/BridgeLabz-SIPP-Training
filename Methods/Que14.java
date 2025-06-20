import java.util.*;

public class Que14 {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double poundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double kilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double gallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double litersToGallons(double liters) {
        return liters * 0.264172;
    }
}

public class TestConvertion {
    public static void main(String[] args) {

        System.out.println(Que14.convertFahrenheitToCelsius(98.6));
        System.out.println(Que14.convertCelsiusToFahrenheit(37));
        System.out.println(Que14.poundsToKilograms(150));
        System.out.println(Que14.kilogramsToPounds(70));
        System.out.println(Que14.gallonsToLiters(2));
        System.out.println(Que14.litersToGallons(5));
    }
}