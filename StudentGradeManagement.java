import java.util.*;

class Student {
    String name;
    int[] marks = new int[3];
    double average;
    char grade;

    void inputDetails(Scanner sc) {
        System.out.print("Enter name: ");
        name = sc.nextLine();
        System.out.print("Enter marks in 3 subjects: ");
        for (int i = 0; i < 3; i++) marks[i] = sc.nextInt();
        sc.nextLine(); // consume newline
    }

    void calculate() {
        int total = 0;
        for (int m : marks) total += m;
        average = total / 3.0;

        if (average >= 91) grade = 'O';
        else if (average >= 81) grade = 'A';
        else if (average >= 71) grade = 'B';
        else if (average >= 61) grade = 'C';
        else grade = 'F';
    }

    void display() {
        System.out.println(name + " | Avg: " + average + " | Grade: " + grade);
    }
}

public class StudentGradeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student  2. View All  3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                Student s = new Student();
                s.inputDetails(sc);
                s.calculate();
                students.add(s);
            } else if (choice == 2) {
                System.out.println("\n--- Student Records ---");
                for (Student s : students) s.display();
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
