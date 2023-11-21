import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface OutgoingStudentFinder {
    Student findBestOutgoingStudent(List<Student> students);
}

class AcademicAchievement {
    private double gpa;

    public AcademicAchievement(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }
}

class ExtracurricularAchievement {
    private String activity;
    private int hoursParticipated;

    public ExtracurricularAchievement(String activity, int hoursParticipated) {
        this.activity = activity;
        this.hoursParticipated = hoursParticipated;
    }

    public String getActivity() {
        return activity;
    }

    public int getHoursParticipated() {
        return hoursParticipated;
    }
}

class Student {
    private String name;
    private AcademicAchievement academicAchievement;
    private ExtracurricularAchievement extracurricularAchievement;

    public Student(String name, AcademicAchievement academicAchievement, ExtracurricularAchievement extracurricularAchievement) {
        this.name = name;
        this.academicAchievement = academicAchievement;
        this.extracurricularAchievement = extracurricularAchievement;
    }

    public String getName() {
        return name;
    }

    public AcademicAchievement getAcademicAchievement() {
        return academicAchievement;
    }

    public ExtracurricularAchievement getExtracurricularAchievement() {
        return extracurricularAchievement;
    }
}

class BestOutgoingStudentFinder implements OutgoingStudentFinder {
    @Override
    public Student findBestOutgoingStudent(List<Student> students) {
        Student bestStudent = null;
        double maxScore = -1;

        for (Student student : students) {
            double academicScore = student.getAcademicAchievement().getGpa();
            int extracurricularScore = student.getExtracurricularAchievement().getHoursParticipated();

            double totalScore = academicScore * 0.7 + extracurricularScore * 0.3;

            if (totalScore > maxScore) {
                maxScore = totalScore;
                bestStudent = student;
            }
        }

        return bestStudent;
    }
}

public class BestOutgoingStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline
            System.out.print("Extracurricular Activity: ");
            String activity = scanner.nextLine();
            System.out.print("Hours Participated: ");
            int hoursParticipated = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            AcademicAchievement academicAchievement = new AcademicAchievement(gpa);
            ExtracurricularAchievement extracurricularAchievement = new ExtracurricularAchievement(activity, hoursParticipated);
            Student student = new Student(name, academicAchievement, extracurricularAchievement);
            students.add(student);
        }

        OutgoingStudentFinder outgoingStudentFinder = new BestOutgoingStudentFinder();
        Student bestOutgoingStudent = outgoingStudentFinder.findBestOutgoingStudent(students);

        if (bestOutgoingStudent != null) {
            System.out.println("Best Outgoing Student: " + bestOutgoingStudent.getName());
        } else {
            System.out.println("No students found.");
        }

        scanner.close();
    }
}
