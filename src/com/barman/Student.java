package com.barman;

import java.text.ParseException;

public class Student extends Person {
    public Student() {
    }

    public Student(int number, String name, String firstName, String dateOfBirth) throws ParseException {
        super(number, name, firstName, dateOfBirth);
    }
}
