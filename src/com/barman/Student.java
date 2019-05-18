package com.barman;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student extends Person {
    private SimpleIntegerProperty registrationNumber;
    private SimpleStringProperty specialty;
    private SimpleStringProperty teacher;
    private SimpleStringProperty sector;

    public Student(){
        super();
        this.specialty = null;
        this.teacher = null;
        this.sector = null;
    }

    public Student(int registrationNumber, String name, String firstName, String dateOfBirth, String specialty, String teacher, String sector) {
        super(name, firstName, dateOfBirth);
        this.registrationNumber = new SimpleIntegerProperty(registrationNumber);
        this.specialty = new SimpleStringProperty(specialty);
        this.teacher = new SimpleStringProperty(teacher);
        this.sector = new SimpleStringProperty(sector);
    }
    public int getRegistrationNumber(){
        return this.registrationNumber.get();
    }

    public void setRegistrationNumber (SimpleIntegerProperty registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getSpecialty() {
        return this.specialty.get();
    }

    public void setSpecialty(SimpleStringProperty specialty) {
        this.specialty = specialty;
    }

    public String getTeacher() {
        return this.teacher.get();
    }

    public void setTeacher(SimpleStringProperty teacher) {
        this.teacher = teacher;
    }

    public String getSector(){
        return this.sector.get();
    }

    public void setSector(SimpleStringProperty sector){
        this.sector = sector;
    }
}