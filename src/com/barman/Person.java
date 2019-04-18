package com.barman;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private int number;
    private String name;
    private String firstName;
    private String dateOfBirth;

    public Person() {

    }

    public Person(int number, String name, String firstName, String dateOfBirth) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        Date date = null;
        try {
            date = dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            System.out.println("Invalid Date Format. Please Enter Date in the following Pattern \"dd/mm/yyyy\"");
        }
        this.number = number;
        this.name = name;
        this.firstName = firstName;
        this.dateOfBirth = date.toString();
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
