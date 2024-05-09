package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Page");

        // Create VBox layout for the entire window
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(40));

        // Create labels, text fields, and buttons
        Label titleLabel = new Label("Welcome to Digital Diet");
        titleLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        Label loginTitleLabel = new Label("Login");
        loginTitleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label usernameLabel = new Label("Username:");
        TextField usernameInput = new TextField();
        usernameInput.setPrefWidth(200);
        usernameInput.setPromptText("Enter your username");
        usernameInput.setOnMouseClicked(e -> clearAlert());

        Label passwordLabel = new Label("Password:");
        TextField passwordInput = new TextField();
        passwordInput.setPrefWidth(200);
        passwordInput.setPromptText("Enter your password");
        passwordInput.setOnMouseClicked(e -> clearAlert());

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            if (usernameInput.getText().isEmpty() || passwordInput.getText().isEmpty()) {
                showAlert("Please enter all fields to login");
            } else {
                // Proceed with login logic
            }
        });

        // Sign Up Button
        Button signupPageButton = new Button("Sign Up");
        signupPageButton.setOnAction(e -> {
            SignupController signupPage = new SignupController();
            signupPage.start(primaryStage);
        });

        // Add elements to the VBox
        root.getChildren().addAll(titleLabel, loginTitleLabel, usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton, signupPageButton);

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

    private void clearAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
