package com.barman;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.ParseException;
import java.time.LocalDate;

public class Teacher extends Person {
    private String module;
    private String degree;
    private Specialty teacherSpecialty;

    public Teacher(int registrationNumber, String name, String firstName, String dateOfBirth, String module, String degree, Specialty teacherSpecialty) throws ParseException {
        super(registrationNumber, name, firstName, dateOfBirth);
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

    public Specialty getTeacherSpecialty() {
        return this.teacherSpecialty;
    }

    public void setTeacherSpecialty(Specialty teacherSpecialty) {
        this.teacherSpecialty = teacherSpecialty;
    }
}
