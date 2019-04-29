package com.barman.controllers;

import com.barman.Person;
import com.barman.Specialty;
import com.barman.Student;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.security.Signature;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentList implements Initializable {
    private String admin = "Chima Stella";

    @FXML private Button logoutButton;

    @FXML
    Button exitButton;

    @FXML
    private Label adminName;

    @FXML
    private Label date;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> firstName;

    @FXML
    private TableColumn<Student, String> dateOfBirth;

    @FXML
    private TableColumn<Student, Integer> registrationNumber;

    // The Specialty
    private Specialty studentSpecialty;

    public StudentList() throws ParseException {
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoutButton = new Button();
        System.out.println(logoutButton.getText());

        // Setting the admin label value to "Chima Stella on line 14"
        adminName = new Label();
//        adminName.setText(admin);
        System.out.println(adminName.getText());
//        adminName.setText(adminName.getText().concat(admin));

        // setting up the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM dd, y");
        final Date today = new Date();
        final String currentDate = dateFormat.format(today);
        date = new Label();
        date.setText(currentDate);

        name = new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        dateOfBirth = new TableColumn<>("Date of Birth");
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        registrationNumber = new TableColumn<>("Registration Number");
        registrationNumber.setCellValueFactory(new PropertyValueFactory<>(("number")));

        studentTable = new TableView<>();
        try {
            studentTable.setItems(getDefaultStudents());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        studentTable.getColumns().addAll(name, firstName, dateOfBirth, registrationNumber);

        // Loop through the table and populate


//
//
//        // Creating an iterator too loop through the list of students
//        Iterator<Student> studentIterator = students.iterator();
//
//        // the actual loop
//        while(studentIterator.hasNext()){
//
//        }
    }

    public ObservableList<Student> getDefaultStudents() throws ParseException {
        // List of Students
        ObservableList<Student> students = FXCollections.observableArrayList();
        // Adding the following Students below
        students.add(new Student(1, "Chima", "Stella", "30/05/1996"));
        students.add(new Student(1, "Zikora", "Somtochukwu", "30/05/2005"));
        students.add(new Student(1, "Abunike", "Moses", "30/05/2000"));
        students.add(new Student(1, "Obinka", "Ogechi", "30/05/2019"));
        students.add(new Student(1, "Uzoanya", "Dominic", "30/05/1996"));

        return students;
    }

    @FXML
    public void handleExitButton (ActionEvent e) {
        System.exit(0);
    }

}
