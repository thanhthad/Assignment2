import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add a student to the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student by ID
    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    // Update a student's information
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return;
            }
        }
    }

    // List all students
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

