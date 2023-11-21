/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrk1;

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
