import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static List<Student> studentList = new ArrayList<>();

    private static void sort() {
        if (studentList.isEmpty()) {
            System.out.println("No students to sort");
            return;
        }
        studentList.sort((s1, s2) -> Float.compare(s2.getGrade(), s1.getGrade()));
        studentList.forEach(System.out::println);
    }

    private static void delete(int deleteId) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (deleteId == student.getId()) {
                iterator.remove();
                System.out.println("Student with ID " + deleteId + " has been deleted.");
                output();
                return;
            }
        }
        System.out.println("No student with ID " + deleteId + " found.");
    }

    private static void find(int id) {
        for (Student student : studentList) {
            if (id == student.getId()) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("No student with ID " + id + " found.");
    }

    private static void find(String name) {
        for (Student student : studentList) {
            if (name.equals(student.getName())) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("No student with name " + name + " found.");
    }

    private static void findByGrade(float minGrade) {
        boolean found = false;
        for (Student student : studentList) {
            if (student.getGrade() >= minGrade) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with grade >= " + minGrade);
        }
    }

    private static void findStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to find a student by ID or Name? \n1: Find by ID \n2: Find by Name ");
        int option = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        switch (option) {
            case 1:
                System.out.println("Input ID that you want to find:");
                int id = scanner.nextInt();
                find(id);
                break;
            case 2:
                System.out.println("Input Name that you want to find:");
                String name = scanner.nextLine();
                find(name);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Input Name of student: ");
        String name = scanner.nextLine();
        System.out.print("Input Student's Age: ");
        int age = scanner.nextInt();
        System.out.print("Input Student's Grade: ");
        float grade = scanner.nextFloat();
        Student student = new Student(id, name, age, grade);
        studentList.add(student);
    }

    private static void output() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            studentList.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Input number of students: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(String.format("Input details for student %d", i + 1));
            input();
        }
        System.out.println("Output information of all students:");
        output();

        System.out.println("Do you want to arrange the list of students? \n1: Yes \n2: No");
        int arrange = scanner.nextInt();
        if (arrange == 1) {
            sort();
        }

        System.out.println("Do you want to delete a student by ID? \n1: Yes \n2: No");
        int deleteOption = scanner.nextInt();
        if (deleteOption == 1) {
            System.out.println("Input ID of student to delete:");
            int deleteId = scanner.nextInt();
            delete(deleteId);
        }

        while (true) {
            System.out.println("Do you want to find a student? \n1: Yes \n2: No");
            int findOption = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            if (findOption == 1) {
                findStudent();
            } else {
                break;
            }
        }

        System.out.println("Do you want to find students with a grade greater than or equal to a certain value? \n1: Yes \n2: No");
        int gradeOption = scanner.nextInt();
        if (gradeOption == 1) {
            System.out.println("Input minimum grade:");
            float minGrade = scanner.nextFloat();
            findByGrade(minGrade);
        }

        scanner.close();
    }
}