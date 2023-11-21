/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrk1;

import java.util.List;

class BestOutgoingStudentFinder implements OutgoingStudentFinder {
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
