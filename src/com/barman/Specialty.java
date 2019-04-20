package com.barman;

import java.util.List;

public class Specialty {
    private String name;
    private String sector;
    private int yearOfStudy;
    private List<Student> students;

    public Specialty() {

    }

    public Specialty(String name, String sector, int yearOfStudy, List students) {
        this.name = name;
        this.sector = sector;
        this.yearOfStudy = yearOfStudy;
        this.students = students;
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

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
