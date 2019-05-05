package com.barman.controllers;

import com.barman.Student;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class AddStudent implements Initializable {
    @FXML
    TextField newStudentName;

    @FXML
    TextField newStudentFirstName;

    @FXML
    DatePicker newStudentDateOfBirth;

    @FXML
    TextField newStudentNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void addStudent() {
        try {
            DateFormat originalFormat = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH);
            DateFormat targetFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date date  = originalFormat.parse(newStudentDateOfBirth.getValue().toString());
            String formattedDate = targetFormat.format(date);

            String dateOfBirth = formattedDate;

            Student newStudent = new Student();

            newStudent.setName(new SimpleStringProperty(newStudentName.getText()));
            newStudent.setFirstName(new SimpleStringProperty(newStudentFirstName.getText()));
            newStudent.setDateOfBirth(dateOfBirth);
            newStudent.setRegistrationNumber(new SimpleIntegerProperty(Integer.parseInt(newStudentNumber.getText())));

            StudentList.handleAddStudent(newStudent);
//            clearInputs();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            showAlert(Alert.AlertType.ERROR, "Incomplete Input Fields", "Missing Input Fields!", "Please Ensure you Complete all Inputs");
        }
    }

    private void clearInputs() {
        newStudentName.setText(null);
        newStudentFirstName.setText(null);
        newStudentNumber.setText(null);
        newStudentDateOfBirth.setValue(null);
    }

    @FXML
    public void handleCancelButton(ActionEvent e){
        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        window.close();
    }

    @FXML
    public void handleClearButton(){
        clearInputs();
    }

    private void showAlert(Alert.AlertType alertType, String alertTitle, String alertHeader, String alertText){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(alertHeader);
        alert.setTitle(alertTitle);
        alert.setContentText(alertText);
        alert.show();
    }
}
