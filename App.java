import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Double> marks;

    public Student(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public void addMark(double mark) {
        marks.add(mark);
    }

    public double calculateTotalMarks() {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    public double computeGPA() {
        return calculateTotalMarks() / marks.size();
    }

    public String getName() {
        return name;
    }

    public List<Double> getMarks() {
        return marks;
    }
}

public class App {
    private List<Student> students;

    public App() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void identifyToppers() {
        double highestGPA = 0;
        List<Student> toppers = new ArrayList<>();

        for (Student student : students) {
            double gpa = student.computeGPA();
            if (gpa > highestGPA) {
                highestGPA = gpa;
                toppers.clear();
                toppers.add(student);
            } else if (gpa == highestGPA) {
                toppers.add(student);
            }
        }

        System.out.println("Toppers: ");
        for (Student topper : toppers) {
            System.out.println(topper.getName() + " with GPA: " + topper.computeGPA());
        }
    }

    public void performanceInsights() {
        for (Student student : students) {
            double gpa = student.computeGPA();
            String grade;
            if (gpa >= 90) {
                grade = "A";
            } else if (gpa >= 80) {
                grade = "B";
            } else if (gpa >= 70) {
                grade = "C";
            } else if (gpa >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            System.out.println(student.getName() + " has GPA: " + gpa + " and Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        Student student1 = new Student("Alice");
        student1.addMark(95);
        student1.addMark(88);
        app.addStudent(student1);

        Student student2 = new Student("Bob");
        student2.addMark(76);
        student2.addMark(85);
        app.addStudent(student2);

        app.identifyToppers();
        app.performanceInsights();
    }
}