package com.barman;

import javafx.beans.property.SimpleStringProperty;

public class Student extends Person {
    private SimpleStringProperty specialty;
    private SimpleStringProperty sector;

    public Student(){
        super();
        this.specialty = null;
    }

    public Student(int registrationNumber, String name, String firstName, String dateOfBirth, String specialty, String sector) {
        super(registrationNumber, name, firstName, dateOfBirth);
        this.specialty = new SimpleStringProperty(specialty);
        this.sector = new SimpleStringProperty(sector);
    }

    public String getSpecialty() {
        return this.specialty.get();
    }

    public void setSpecialty(SimpleStringProperty specialty) {
        this.specialty = specialty;
    }

    public String getSector(){
        return this.sector.get();
    }

    public void setSector(SimpleStringProperty sector){
        this.sector = sector;
    }
}