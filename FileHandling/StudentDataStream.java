import java.io.*;
import java.util.Scanner;

public class StudentDataStream {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Write student data to file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {

            System.out.print("Enter number of students: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Student " + (i + 1));
                System.out.print("Roll Number: ");
                int roll = Integer.parseInt(sc.nextLine());

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("GPA: ");
                float gpa = Float.parseFloat(sc.nextLine());

                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeFloat(gpa);
            }

            System.out.println("\nStudent data written to file: " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read student data from file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nReading student data from file:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                float gpa = dis.readFloat();

                System.out.println("Roll No: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
