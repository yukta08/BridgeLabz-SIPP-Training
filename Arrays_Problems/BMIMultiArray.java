import java.util.Scanner;

public class BMIMultiArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double weight = sc.nextDouble();
            double height = sc.nextDouble();
            if (weight <= 0 || height <= 0) {
                i--;
                continue;
            }
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);

            if (personData[i][2] < 18.5)
                weightStatus[i] = "Underweight";
            else if (personData[i][2] < 25)
                weightStatus[i] = "Normal";
            else if (personData[i][2] < 30)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        for (int i = 0; i < number; i++) {
            System.out.println("Height: " + personData[i][1] + ", Weight: " + personData[i][0] + ", BMI: " + personData[i][2] + ", Status: " + weightStatus[i]);
        }
    }
}
