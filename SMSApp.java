import java.util.ArrayList;
import java.util.Scanner;

public class SMSApp {
    public static void main(String[] args) {
        new SMSApp().start();
    }

    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    private void start() {
        int choice;
        do {
            menu();
            choice = intIn("Choose: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> listStudents();
                case 3 -> searchStudent();
                case 4 -> removeStudent();
                case 5 -> System.out.println("👋 Bye!");
                default -> System.out.println("⚠️  Invalid choice\n");
            }
        } while (choice != 5);
    }

    private void menu() {
        System.out.println("""
            ===== MENU =====
            1. Add Student
            2. Display All Students
            3. Search Student by Roll
            4. Remove Student by Roll
            5. Exit
        """);
    }

    private void addStudent() {
        System.out.print("Name: ");  String name = sc.nextLine();
        System.out.print("Roll: ");  String roll = sc.nextLine();
        System.out.print("Grade: "); String grade = sc.nextLine();
        students.add(new Student(name, roll, grade));
        System.out.println(" Added!\n");
    }

    private void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students.\n");
            return;
        }
        System.out.println("\nName\tRoll\tGrade");
        System.out.println("-------------------------");
        for (Student s : students) System.out.println(s);
        System.out.println();
    }

    private void searchStudent() {
        System.out.print("Enter roll to search: ");
        String roll = sc.nextLine();
        for (Student s : students)
            if (s.roll.equals(roll)) {
                System.out.println("🔍 Found: " + s + "\n");
                return;
            }
        System.out.println("Not found.\n");
    }

    private void removeStudent() {
        System.out.print("Enter roll to remove: ");
        String roll = sc.nextLine();
        boolean removed = students.removeIf(s -> s.roll.equals(roll));
        System.out.println(removed ? "✅ Removed.\n" : "Roll not found.\n");
    }

    private int intIn(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }
}

class Student {
    String name, roll, grade;
    Student(String n, String r, String g) {
        name = n; roll = r; grade = g;
    }
    public String toString() {
        return name + "\t" + roll + "\t" + grade;
    }
}
