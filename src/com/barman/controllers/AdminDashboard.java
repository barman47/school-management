package com.barman.controllers;

import com.barman.Specialty;
import com.barman.Student;
import com.barman.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class AdminDashboard implements Initializable {
    private final String admin = "Chima Stella";

    private final String nonSelected = "None Selected";

    @FXML
    private Label adminName;

    @FXML
    private Label date;

    @FXML
    private ComboBox studentCategoryComboBox;

    @FXML
    private ComboBox moduleSpecialtyComboBox;

    @FXML
    private TextField searchBox;

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

    // Observable list of found students
    private static ObservableList<Student> returnedStudents = FXCollections.observableArrayList();

    //list of Specialties
    Specialty computerSpecialty = new Specialty();

    Specialty mathsSpecialty = new Specialty();

    Specialty biologySpecialty = new Specialty();

    // List of Teachers
    private ObservableList<Teacher> teachers = FXCollections.observableArrayList();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting the admin label value to "Chima Stella"
        adminName.setText("Welcome back ".concat(admin));

        // setting up the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM dd, y");
        final Date today = new Date();
        final String currentDate = dateFormat.format(today);
        date.getStyleClass().add("date");
        date.setText(currentDate);

        loadTable();
    }

   public ObservableList<Student> getDefaultStudents() {
        // Adding the following Students below
        students.add(new Student(1, "Chima", "Stella", "30/05/1996", "Computer Science", "Chima Stella", "Isil"));
        students.add(new Student(2, "Zikora", "Somtochukwu", "30/05/2005", "Mathematics", "Somtochukwu Zikora", "Probability and Statistics"));
        students.add(new Student(3, "Abunike", "Moses", "30/05/2000", "Biology", "Ogechi Obinka", "Ecology"));
        students.add(new Student(4, "Obinka", "Ogechi", "30/05/2019", "Biology", "Ogechi Obinka", "Zoology"));
        students.add(new Student(5, "Uzoanya", "Dominic", "30/05/1996", "Computer Science", "Chima Stella", "Acad"));

        return students;
    }

    public ObservableList<Teacher> getDefaultTeachers() {
        // Adding the following Students below
        teachers.add(new Teacher("Chima", "Stella", "30/08/1996", "Computer Module", "PhD", "Isil"));
        teachers.add(new Teacher("Uzoanya", "Dominic", "30/05/1996", "Computer Module", "PhD", "Acad"));

        teachers.add(new Teacher("Zikora", "Somtochukwu", "23/05/1987", "Mathematics Module", "PhD", "Probability and Statistics"));
        teachers.add(new Teacher("Obinka", "Ogechi", "30/05/2019", "Biology Module", "PhD", "Zoology"));

        return teachers;
    }

    public ObservableList<Specialty> getDefaultSpecialty() {
        // Adding the following Students below
        ObservableList<Specialty> specialties = FXCollections.observableArrayList();

        computerSpecialty.setName("Computer Science");
        computerSpecialty.setStudents(getDefaultStudents());
        computerSpecialty.setSector("Isil Sector");
        computerSpecialty.setYearOfStudy(2019);
        specialties.add(computerSpecialty);

        // Default Maths Students
        List<Student> mathsStudents = new ArrayList<>();
        mathsStudents.add(new Student(22, "Burna", "Boy", "12/03/1876", mathsSpecialty.getName(), "Zikora Somtochukwu", mathsSpecialty.getSector()));
        mathsStudents.add(new Student(23, "Paul", "Eru", "21/03/2001", mathsSpecialty.getName(), "Zikora Somtochukwu", mathsSpecialty.getSector()));
        mathsStudents.add(new Student(24, "Mary", "Eru", "22/10/1990", mathsSpecialty.getName(), "Zikora Somtochukwu", mathsSpecialty.getSector()));

        mathsSpecialty.setName("Mathematics");
        mathsSpecialty.setStudents(mathsStudents);
        mathsSpecialty.setSector("Probability and Staticstics");
        mathsSpecialty.setYearOfStudy(2019);
        specialties.add(mathsSpecialty);

        // Default Biology Students
        List<Student> biologyStudents = new ArrayList<>();
        biologyStudents.add(new Student(25, "Amara", "Obinka", "02/05/1995", biologySpecialty.getName(), "Ogechi Obinka", biologySpecialty.getSector()));
        biologyStudents.add(new Student(26, "Ebere", "Ofoedu", "18/03/1984", biologySpecialty.getName(), "Ogechi Obinka", biologySpecialty.getSector()));
        biologyStudents.add(new Student(27, "Prince", "Daniel", "12/10/1920", biologySpecialty.getName(), "Ogechi Obinka", biologySpecialty.getSector()));

        biologySpecialty.setName("Biology");
        biologySpecialty.setStudents(biologyStudents);
        biologySpecialty.setSector("Ecology");
        biologySpecialty.setYearOfStudy(2019);
        specialties.add(biologySpecialty);

        return specialties;
    }

    private void loadTable () {
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

    public static void handleAddStudent(Student student){
        students.add(new Student(student.getRegistrationNumber(), student.getName(), student.getFirstName(), student.getDateOfBirth(), student.getSpecialty(), student.getTeacher(), student.getSector()));
        System.out.println("Successfully added Student " + student.getName() + " " + student.getFirstName());
    }

    public static int getLastStudentNumber(){
        int studentNumber = students.get(students.size() - 1).getRegistrationNumber();
        return studentNumber;
    }

    @FXML
    public void handleStudentCategoryComboBox(ActionEvent e){
        moduleSpecialtyComboBox.getSelectionModel().select(0);
    }

    @FXML
    public void handleModuleSpecialtyComboBox(ActionEvent e){
        studentCategoryComboBox.getSelectionModel().select(0);
    }

    @FXML
    public void handleFindStudent() throws IOException {
        if(searchBox.getText().isEmpty() || searchBox.getText().trim().isEmpty()) {
            AddStudent.showAlert(Alert.AlertType.ERROR, "Empty Search Parameter", "Please Provide Student Search Data", "");
            searchBox.requestFocus();
        } else {
            if(studentCategoryComboBox.getSelectionModel().getSelectedItem().toString().equals(nonSelected) && moduleSpecialtyComboBox.getSelectionModel().getSelectedItem().toString().equals(nonSelected)){
                AddStudent.showAlert(Alert.AlertType.ERROR, "Invalid Search Category", "Cannot Find Student", "Please Choose a Category to Find a Student by.");
                studentCategoryComboBox.requestFocus();
            } else {
                findStudent();
            }
        }
    }

    private void findStudent() throws IOException {
        List<Student> studentList = new ArrayList<>(students);
        String searchText = searchBox.getText();
        String searchCategory;
        boolean studentExists = false;
        if(studentCategoryComboBox.getSelectionModel().getSelectedItem().toString() != nonSelected && moduleSpecialtyComboBox.getSelectionModel().getSelectedItem().toString().equals(nonSelected)) {
            searchCategory = studentCategoryComboBox.getSelectionModel().getSelectedItem().toString();
            switch (searchCategory){
                case "Registration Number":
                    try{
                        System.out.println("Searching by Number Number");
                        for(Student student: studentList){
                            if(student.getRegistrationNumber() == Integer.parseInt(searchText)) {
                                System.out.println(student.getFirstName());
                                returnedStudents.add(student);
                                studentExists = true;
                                break;
                            }
                        }

                        if(studentExists == false) {
                            AddStudent.showAlert(Alert.AlertType.INFORMATION, "No Results", "NO STUDENT FOUND!", "Search Found no Student matching the Provided Registration Number.");
                        } else {
                            displaySearchResults();
                        }
                    }catch(NumberFormatException ex){
                        AddStudent.showAlert(Alert.AlertType.ERROR, "Incorrect Input Format", "NO STUDENT FOUND!", "Only Numbers allowed.");
                    }

                    break;

                case "Name":
                    System.out.println("Searching by Name");
                    for(Student student: studentList){
                        if(student.getName().equalsIgnoreCase(searchText)) {
                            returnedStudents.add(student);
                            studentExists = true;
                        }
                    }

                    if(studentExists == false) {
                        AddStudent.showAlert(Alert.AlertType.INFORMATION, "No Results", "NO STUDENT FOUND!", "Search Found no Student matching the Provided Name.");
                    } else {
                        displaySearchResults();
                    }

                    break;

                case "First Name":
                    System.out.println("Searching by First Name");
                    for(Student student: studentList){
                        if(student.getFirstName().equalsIgnoreCase(searchText)) {
                            returnedStudents.add(student);
                            studentExists = true;
                        }
                    }

                    if(studentExists == false) {
                        AddStudent.showAlert(Alert.AlertType.INFORMATION, "No Results", "NO STUDENT FOUND!", "Search Found no Student matching the Provided Name.");
                    } else {
                        displaySearchResults();
                    }

                    break;

                case "Date of Birth":
                    System.out.println("Searching by Date of Birth");
                    for(Student student: studentList){
                        if(student.getDateOfBirth().equals(searchText)) {
                            returnedStudents.add(student);
                            studentExists = true;
                        }
                    }
                    if(studentExists == false) {
                        AddStudent.showAlert(Alert.AlertType.INFORMATION, "No Results", "NO STUDENT FOUND!", "Search Found no Student. Please make sure you provide a correct birthday.");
                    } else {
                        displaySearchResults();
                    }

                    break;

                default:
                    System.out.println("default");
                    break;
            }
        }

        if(moduleSpecialtyComboBox.getSelectionModel().getSelectedItem().toString() != nonSelected && studentCategoryComboBox.getSelectionModel().getSelectedItem().toString().equals(nonSelected)) {
            searchCategory = moduleSpecialtyComboBox.getSelectionModel().getSelectedItem().toString();
            switch(searchCategory){
                case "Teacher":
                    System.out.println("Searching by Teacher");
                    for(Student student: studentList){
                        if(student.getTeacher().toLowerCase().contains(searchText.toLowerCase())) {
                            returnedStudents.add(student);
                            studentExists = true;
                        }
                    }
                    if(studentExists == false) {
                        AddStudent.showAlert(Alert.AlertType.INFORMATION, "No Results", "NO STUDENT FOUND!", "Search Found no Student. Please make sure you provide a correct birthday.");
                    } else {
                        displaySearchResults();
                    }
                    break;

                case "Specialty":
                    System.out.println("Searching by Specialty");
                    for(Student student: studentList){
                        if(student.getSpecialty().contains(searchText)) {
                            returnedStudents.add(student);
                            studentExists = true;
                        }
                    }
                    if(studentExists == false) {
                        AddStudent.showAlert(Alert.AlertType.INFORMATION, "No Results", "NO STUDENT FOUND!", "Search Found no Student. Please make sure you provide a correct birthday.");
                    } else {
                        displaySearchResults();
                    }

                    break;

                default:
                    System.out.println("Default");
                    break;
            }
        }
    }

    private void displaySearchResults() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/searchResults.fxml"));
        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle("Search Results");
        window.setResizable(false);
        window.centerOnScreen();
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                AdminDashboard.clearSearchList();
            }
        });
    }

    public static ObservableList<Student> getFoundStudents(){
        return returnedStudents;
    }

    public static void clearSearchList(){
        ObservableList<Student> emptyList = FXCollections.observableArrayList();
        returnedStudents = emptyList;
    }

    public static void clearDefaults(){
        students = getFoundStudents();
    }

    @FXML
    public void handleLogoutButton(ActionEvent e){
//        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        Stage stage = new Stage();
        Label logoutText = new Label("Confirm Logout. You will be returned to the login screen.");
        logoutText.setPadding(new Insets(20, 10, 20, 10));

        Button okayButton = new Button("Logout");
        okayButton.setDefaultButton(true);
        okayButton.setOnAction((event -> {
            Stage parentWindow = (Stage) ((Node)e.getSource()).getScene().getWindow().getScene().getWindow();
            Stage window = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../views/login.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            window.setTitle("Admin Login");
            Scene loginScene = new Scene(root, 300, 275);
            window.setResizable(false);
            window.setScene(loginScene);
            clearDefaults();
            stage.close();
            parentWindow.close();
            window.show();
        }));

        Button cancelButton = new Button("Cancel");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction((event -> stage.close()));


        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.getChildren().addAll(okayButton, cancelButton);
        hBox.setPadding(new Insets(0, 0, 10, 150));

        VBox container = new VBox();
        container.setSpacing(20);
        container.getChildren().addAll(logoutText, hBox);

        Scene scene = new Scene(container, 400, 120);

        stage.setTitle("Confirm Logout");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void handleExitButton (ActionEvent e) {
        System.exit(0);
    }
}
