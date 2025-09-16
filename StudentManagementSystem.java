package Student_Management_System;
import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private String grade;

    // Constructor
    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Grade: " + grade;
    }
}

// Main class
public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Add a student
    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        students.add(new Student(id, name, grade));
        System.out.println("✅ Student added successfully!\n");
    }

    // Remove student by ID
    public void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("✅ Student removed successfully!\n");
        } else {
            System.out.println("⚠️ Student not found!\n");
        }
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students found!\n");
        } else {
            System.out.println("📋 Student List:");
            for (Student s : students) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    // Menu
    public void menu() {
        while (true) {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> displayStudents();
                case 4 -> {
                    System.out.println("👋 Exiting...");
                    return;
                }
                default -> System.out.println("⚠️ Invalid choice, try again!\n");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }
}
