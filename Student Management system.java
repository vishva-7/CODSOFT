import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student class to represent individual students
class Student {
    private String name;
    private int rollNumber;
    private String grade;

    // Constructor
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // toString method for displaying student information
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

// Main class containing the StudentManagementSystem
class Main {
    // StudentManagementSystem class to manage the collection of students
    static class StudentManagementSystem {
        private List<Student> studentList;
        private Scanner scanner;

        // Constructor
        public StudentManagementSystem() {
            this.studentList = new ArrayList<>();
            this.scanner = new Scanner(System.in);
        }

        // Method to display menu
        private void displayMenu() {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
        }

        // Method to add a student
        private void addStudent() {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter roll number:");
            int rollNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            System.out.println("Enter grade:");
            String grade = scanner.nextLine();

            Student student = new Student(name, rollNumber, grade);
            studentList.add(student);
            System.out.println("Student added successfully!");
        }

        // Method to view all students
        private void viewStudents() {
            System.out.println("List of Students:");
            if (studentList.isEmpty()) {
                System.out.println("No students available.");
            } else {
                for (Student student : studentList) {
                    System.out.println(student);
                }
            }
        }

        // Method to remove a student
        private void removeStudent() {
            System.out.println("Enter roll number of student to remove:");
            int rollNumber = scanner.nextInt();
            boolean found = false;
            for (Student student : studentList) {
                if (student.getRollNumber() == rollNumber) {
                    studentList.remove(student);
                    System.out.println("Student removed successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student with roll number " + rollNumber + " not found.");
            }
        }

        // Method to start the student management system
        public void start() {
            displayMenu();

            int choice;
            do {
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        removeStudent();
                        break;
                    case 4:
                        System.out.println("Thank You!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 4);

            scanner.close();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.start();
    }
}
