package com.barman;

public class Specialty {
    private String name;
    private String sector;
    private int yearOfStudy;
    private Student students;

    public Specialty() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return this.sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Student getStudents() {
        return this.students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }
}
