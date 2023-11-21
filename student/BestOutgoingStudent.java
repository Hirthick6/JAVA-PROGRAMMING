/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrk1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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

        BestOutgoingStudentFinder outgoingStudentFinder = new BestOutgoingStudentFinder();
        Student bestOutgoingStudent = outgoingStudentFinder.findBestOutgoingStudent(students);

        if (bestOutgoingStudent != null) {
            System.out.println("Best Outgoing Student: " + bestOutgoingStudent.getName());
        } else {
            System.out.println("No students found.");
        }

        scanner.close();
    }
}