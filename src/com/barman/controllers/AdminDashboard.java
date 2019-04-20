package com.barman.controllers;

import com.barman.Specialty;
import com.barman.Student;
import javafx.fxml.FXML;

import java.text.ParseException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AdminDashboard {
    // The Specialty
    private Specialty studentSpecialty;
    // A List of Students
    private List<Student> students;
    @FXML
    public void initialize() throws ParseException {
        // initializing the list of students to a LinkedList
        students = new LinkedList<>();

        // Adding the following Students below
        students.add(new Student(1, "Chima", "Stella", "30/05/1996"));
        students.add(new Student(1, "Zikora", "Somtochukwu", "30/05/2005"));
        students.add(new Student(1, "Abunike", "Moses", "30/05/2000"));
        students.add(new Student(1, "Obinka", "Ogechi", "30/05/2019"));
        students.add(new Student(1, "Uzoanya", "Dominic", "30/05/1996"));


        // Creating an iterator too loop through the list of students
        Iterator<Student> studentIterator = students.iterator();

        // the actual loop
        while(studentIterator.hasNext()){

        }
    }
}
