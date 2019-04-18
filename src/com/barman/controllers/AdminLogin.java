package com.barman.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLogin {
    @FXML
    private Label usernameErrorMessage;

    @FXML
    private Label passwordErrorMessage;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button adminLoginButton;

    private final String name = "Chima";
    private final String firstName = "Stella";

    private String adminUsername;
    private String adminPassword;

    @FXML
    public void initialize () {
        adminLoginButton.setDisable(true);
    }

    @FXML
    public void handleLogin (ActionEvent e) throws IOException {
        adminUsername = username.getText();
        adminPassword = password.getText();
        if (adminUsername.equals(name) && adminPassword.equals(firstName)) {
            System.out.println("Correct username");
            usernameErrorMessage.setText("");
            passwordErrorMessage.setText("");

            Parent root = FXMLLoader.load(getClass().getResource("../views/adminDashboard.fxml"));
            Scene adminScene = new Scene(root, 800, 600);
            Stage loginStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            loginStage.hide();
            loginStage.setScene(adminScene);
            loginStage.setTitle("Admin Dashboard");
            loginStage.setResizable(true);
            loginStage.setMaximized(true);
            loginStage.centerOnScreen();
            loginStage.show();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setHeaderText("INVALID LOGIN DETAILS");
            errorAlert.setContentText("Username or Password is incorrect! Please Check.");
            errorAlert.setTitle("WARNING");
            errorAlert.show();

            if(!adminUsername.equals(name)){
                usernameErrorMessage.setText("Incorrect Username");
            } else {
                usernameErrorMessage.setText("");
            }

            if (!adminPassword.equals(firstName)){
                passwordErrorMessage.setText("Incorrect Password");
            } else {
                passwordErrorMessage.setText("");
            }
        }
    }

    @FXML
    public void handleKeyReleased () {
        adminUsername = username.getText();
        adminPassword = password.getText();
        if(!adminPassword.isBlank() && !adminUsername.isBlank()) {
            adminLoginButton.setDisable(false);
        } else {
            adminLoginButton.setDisable(true);
        }
    }
}
