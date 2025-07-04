import java.util.*;

// Node representing a student
class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Linked List for Student Records
class StudentList {
    Student head;

    // Add student at beginning
    void addAtBeginning(Student s) {
        s.next = head;
        head = s;
    }

    // Add student at end
    void addAtEnd(Student s) {
        if (head == null) {
            head = s;
        } else {
            Student temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = s;
        }
    }

    // Add at specific position (0-based index)
    void addAtPosition(Student s, int pos) {
        if (pos == 0) {
            addAtBeginning(s);
            return;
        }
        Student temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }
        s.next = temp.next;
        temp.next = s;
    }

    // Delete by roll number
    void deleteByRoll(int roll) {
        if (head == null) return;

        if (head.rollNo == roll) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
            return;
        }

        temp.next = temp.next.next;
    }

    // Search by roll number
    Student searchByRoll(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == roll) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Update grade
    void updateGrade(int roll, char newGrade) {
        Student s = searchByRoll(roll);
        if (s != null) {
            s.grade = newGrade;
            System.out.println("Grade updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display all records
    void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No records to display.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name +
                    ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

// Main class to run the application
public class Student_Record_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();

        while (true) {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position");
            System.out.println("4. Delete by Roll No\n5. Search by Roll No\n6. Update Grade");
            System.out.println("7. Display All\n8. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade = sc.next().charAt(0);

                    Student s = new Student(roll, name, age, grade);
                    if (choice == 1) list.addAtBeginning(s);
                    else if (choice == 2) list.addAtEnd(s);
                    else {
                        System.out.print("Enter Position (0-indexed): ");
                        int pos = sc.nextInt();
                        list.addAtPosition(s, pos);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Roll No to delete: ");
                    int roll = sc.nextInt();
                    list.deleteByRoll(roll);
                }
                case 5 -> {
                    System.out.print("Enter Roll No to search: ");
                    int roll = sc.nextInt();
                    Student found = list.searchByRoll(roll);
                    if (found != null) {
                        System.out.println("Found: " + found.name + ", Age: " + found.age + ", Grade: " + found.grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter Roll No to update: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter new Grade: ");
                    char grade = sc.next().charAt(0);
                    list.updateGrade(roll, grade);
                }
                case 7 -> list.displayAll();
                case 8 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
