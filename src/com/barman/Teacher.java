package com.barman;

public class Teacher extends Person {
    private String module;
    private String degree;
    private String teacherSpecialty;

    public Teacher(){
        super();
        this.module = null;
        this.degree = null;
        this.teacherSpecialty = null;
    }

    public Teacher(String name, String firstName, String dateOfBirth, String module, String degree, String teacherSpecialty) {
        super(name, firstName, dateOfBirth);
        this.module = module;
        this.degree = degree;
        this.teacherSpecialty = teacherSpecialty;
    }

    public String getModule() {
        return this.module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTeacherSpecialty() {
        return this.teacherSpecialty;
    }

    public void setTeacherSpecialty(String teacherSpecialty) {
        this.teacherSpecialty = teacherSpecialty;
    }
}
