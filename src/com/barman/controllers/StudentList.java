package com.barman.controllers;

import com.barman.Person;
import com.barman.Specialty;
import com.barman.Student;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentList implements Initializable {
    private String admin = "Chima Stella";

    @FXML
    private Button logoutButton;

    @FXML
    private Button exitButton;

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

    //Observable List of Students
    private static ObservableList<Student> students = FXCollections.observableArrayList();

    // The Specialty
    private Specialty studentSpecialty;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting the admin label value to "Chima Stella on line 14"
        System.out.println(adminName.getText());
        adminName.setText("Welcome back ".concat(admin));

        // setting up the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM dd, y");
        final Date today = new Date();
        final String currentDate = dateFormat.format(today);
        date.setText(currentDate);

        try {
            loadTable();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

   public ObservableList<Student> getDefaultStudents() throws ParseException {
        // Adding the following Students below
        students.add(new Student(1, "Chima", "Stella", "30/05/1996"));
        students.add(new Student(2, "Zikora", "Somtochukwu", "30/05/2005"));
        students.add(new Student(3, "Abunike", "Moses", "30/05/2000"));
        students.add(new Student(4, "Obinka", "Ogechi", "30/05/2019"));
        students.add(new Student(5, "Uzoanya", "Dominic", "30/05/1996"));

        return students;
    }

    private void loadTable () throws ParseException {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        registrationNumber.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        studentTable.setItems(getDefaultStudents());
    }

    @FXML
    private void addStudent() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/addStudentModal.fxml"));
        Scene addStudentScene = new Scene(root);
        Stage addStudentWindow = new Stage();
        addStudentWindow.setScene(addStudentScene);
        addStudentWindow.setTitle("Add Student");
        addStudentWindow.setResizable(false);
        addStudentWindow.centerOnScreen();
        addStudentWindow.initModality(Modality.APPLICATION_MODAL);
        addStudentWindow.show();
    }

    public static void handleAddStudent(Student student) throws ParseException {
        students.add(new Student(student.getRegistrationNumber(), student.getName(), student.getFirstName(), student.getDateOfBirth()));
        System.out.println("Successfully added Student " + student.getName() + " " + student.getFirstName());
    }

    @FXML
    public void handleExitButton (ActionEvent e) {
        System.exit(0);
    }
}
