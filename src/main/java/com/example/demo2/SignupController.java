package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignupController extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Signup Page");

        // Create VBox layout for the entire window
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(40));

        // Title
        Label titleLabel = new Label("Welcome to Digital Diet");
        titleLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        // Signup label
        Label signupLabel = new Label("Sign Up Today!");
        signupLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create GridPane for form fields
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Name
        Label nameLabel = new Label("Name:");
        TextField nameInput = new TextField();
        grid.addRow(0, nameLabel, nameInput);

        // Last Name
        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameInput = new TextField();
        grid.addRow(1, lastNameLabel, lastNameInput);

        // Password
        Label passwordLabel = new Label("Password:");
        PasswordField passwordInput = new PasswordField();
        grid.addRow(2, passwordLabel, passwordInput);

        // Re-enter Password
        Label rePasswordLabel = new Label("Re-enter Password:");
        PasswordField rePasswordInput = new PasswordField();
        grid.addRow(3, rePasswordLabel, rePasswordInput);

        // Email
        Label emailLabel = new Label("Email:");
        TextField emailInput = new TextField();
        grid.addRow(4, emailLabel, emailInput);

        // Phone
        Label phoneLabel = new Label("Phone:");
        TextField phoneInput = new TextField();
        grid.addRow(5, phoneLabel, phoneInput);

        // Signup Button
        Button signupButton = new Button("Sign Up");
        signupButton.setOnAction(e -> {
            if (nameInput.getText().isEmpty() || lastNameInput.getText().isEmpty() || passwordInput.getText().isEmpty()
                    || rePasswordInput.getText().isEmpty() || emailInput.getText().isEmpty() || phoneInput.getText().isEmpty()) {
                showAlert("Please enter all fields to sign up");
            } else {
                // Proceed with sign-up logic
            }
        });

        // Back to Login Button
        Button loginPageButton = new Button("Back to Login");
        loginPageButton.setOnAction(e -> {
            LoginController loginPage = new LoginController();
            loginPage.start(primaryStage);
        });


        // Add elements to the VBox
        root.getChildren().addAll(titleLabel, signupLabel, grid, signupButton, loginPageButton);
        root.setSpacing(10);

        // Create Scene
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
