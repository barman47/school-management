package com.barman;

import java.time.LocalDate;

public class Student extends Person {
    public Student(){
        super();
    }
    public Student(int registrationNumber, String name, String firstName, String dateOfBirth) {
        super(registrationNumber, name, firstName, dateOfBirth);
    }
}
