package com.barman.controllers;

import com.barman.Student;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
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

    @FXML
    private ComboBox specialtyComboBox;

    @FXML
    private ComboBox sectorComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setNewStudentNumber();
    }

    @FXML
    public void handleSpecialityComboBox(ActionEvent e){
        String specialty = specialtyComboBox.getSelectionModel().getSelectedItem().toString();

        String sector1, sector2, sector3;

        switch (specialty) {
            case "Mathematics":
                sector1 = "Probability and Statistics";
                sector2 = "Operational Research";
                sector3 = "Pure Mathematics";
                sectorComboBox.getItems().clear();
                sectorComboBox.getItems().addAll(sector1, sector2, sector3);
                break;

            case "Computer Science":
                sector1 = "Isil";
                sector2 = "Acad";
                sectorComboBox.getItems().clear();
                sectorComboBox.getItems().addAll(sector1, sector2);
                break;

            case "Biology":
                sector1 = "Ecology";
                sector2 = "Zoology";
                sectorComboBox.getItems().clear();
                sectorComboBox.getItems().addAll(sector1, sector2);
                break;

            default:
                sectorComboBox.getItems().clear();
                sectorComboBox.setValue("Choose Sector");
                break;
        }
        if(specialtyComboBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase(""));
//        moduleSpecialtyComboBox.getSelectionModel().select(0);
    }

    @FXML
    public void addStudent() {
        try {
            DateFormat originalFormat = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH);
            DateFormat targetFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date date  = originalFormat.parse(newStudentDateOfBirth.getValue().toString());
            String formattedDate = targetFormat.format(date);

            String dateOfBirth = formattedDate;

            if(specialtyComboBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Choose Specialty") || sectorComboBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("Choose Sector")){
                showAlert(Alert.AlertType.ERROR, "Incomplete Input Fields", "Missing Input Fields!", "Please Select your Specialty and Sector");
                specialtyComboBox.requestFocus();
            } else {
                System.out.println("Specialty " + specialtyComboBox.getSelectionModel().getSelectedItem().toString());

                System.out.println("Sector " + sectorComboBox.getSelectionModel().getSelectedItem().toString());
                Student newStudent = new Student();

                newStudent.setName(new SimpleStringProperty(newStudentName.getText()));
                newStudent.setFirstName(new SimpleStringProperty(newStudentFirstName.getText()));
                newStudent.setDateOfBirth(dateOfBirth);
                newStudent.setRegistrationNumber(new SimpleIntegerProperty(Integer.parseInt(newStudentNumber.getText())));
                newStudent.setSpecialty(new SimpleStringProperty(specialtyComboBox.getSelectionModel().getSelectedItem().toString()));
                newStudent.setSector(new SimpleStringProperty(sectorComboBox.getSelectionModel().getSelectedItem().toString()));

                AdminDashboard.handleAddStudent(newStudent);
                clearInputs();
                setNewStudentNumber();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            showAlert(Alert.AlertType.ERROR, "Incomplete Input Fields", "Missing Input Fields!", "Please Ensure you Complete all Inputs");
        }
    }

    private void clearInputs() {
        newStudentName.setText(null);
        newStudentFirstName.setText(null);
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

    public static void showAlert(Alert.AlertType alertType, String alertTitle, String alertHeader, String alertText){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(alertHeader);
        alert.setTitle(alertTitle);
        alert.setContentText(alertText);
        alert.show();
    }

    private void setNewStudentNumber() {
        newStudentNumber.setText(Integer.toString(AdminDashboard.getLastStudentNumber() + 1));
    }
}
