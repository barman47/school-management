package com.barman.controllers;

import com.barman.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchResults implements Initializable {
    @FXML
    private Label searchStat;

    @FXML
    private TableView<Student> returnedSearchTable;

    @FXML
    private TableColumn<Student, String> name;

    @FXML
    private TableColumn<Student, String> firstName;

    @FXML
    private TableColumn<Student, String> dateOfBirth;

    @FXML
    private TableColumn<Student, Integer> registrationNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchStat.setText("Found " + AdminDashboard.getFoundStudents().size() + " Result(s).");
        loadTable();
    }

    private void loadTable() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        registrationNumber.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        returnedSearchTable.setItems(AdminDashboard.getFoundStudents());
    }

    @FXML
    public void handleOkayButton(ActionEvent e){
        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        window.close();
        AdminDashboard.clearSearchList();
    }
}
