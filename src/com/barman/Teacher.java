package com.barman;

import java.text.ParseException;

public class Teacher extends Person {
    public Teacher() {

    }

    public Teacher(int number, String name, String firstName, String dateoFBirth) throws ParseException {
        super(number, name, firstName, dateoFBirth);
    }
}
