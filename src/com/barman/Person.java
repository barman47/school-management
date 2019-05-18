package com.barman;

import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Person {
    private SimpleStringProperty name;
    private SimpleStringProperty firstName;
    private SimpleStringProperty dateOfBirth;

    public Person(){
        this.name = new SimpleStringProperty("");
        this.firstName = new SimpleStringProperty("");
        this.dateOfBirth = new SimpleStringProperty("");
    }

    public Person(String name, String firstName, String dateOfBirth){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateOfBirth, dateFormatter);

        int year = date.getYear();
        int day = date.getDayOfMonth();
        Month month = date.getMonth();
        int monthAsInt = month.getValue();

        String mainDate = day + "/" + monthAsInt + "/" + year;

        this.name = new SimpleStringProperty(name);
        this.firstName = new SimpleStringProperty(firstName);
        this.dateOfBirth = new SimpleStringProperty(mainDate);
    }

    public String getName(){
        return this.name.get();
    }

    public void setName(SimpleStringProperty name){
        this.name = name;
    }

    public String getFirstName(){
        return this.firstName.get();
    }

    public void setFirstName(SimpleStringProperty firstName){
        this.firstName = firstName;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth.get();
    }

    public void setDateOfBirth(String dateOfBirth){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateOfBirth, dateFormatter);

        int year = date.getYear();
        int day = date.getDayOfMonth();
        Month month = date.getMonth();
        int monthAsInt = month.getValue();

        String mainDate = day + "/" + monthAsInt + "/" + year;
        this.dateOfBirth = new SimpleStringProperty(mainDate);
    }
}