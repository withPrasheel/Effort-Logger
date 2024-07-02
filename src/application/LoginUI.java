package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginUI{

     public static void showLoginOrRegisterForm(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        Button signupButton = new Button("Sign Up");
        GridPane.setConstraints(signupButton, 1, 3);

        Label loginStatus = new Label("");
        GridPane.setConstraints(loginStatus, 1, 4);

        loginButton.setOnAction(e -> {
            String inputUsername = usernameInput.getText();
            String inputPassword = passwordInput.getText();
            boolean authenticated = Authentication.authenticateUser(inputUsername, inputPassword);
            if (authenticated) {
                loginStatus.setText("Login successful!");
            } else {
                loginStatus.setText("Login failed. Please try again.");
            }
        });

        signupButton.setOnAction(e -> {
            RegistrationUI.showRegistrationForm(primaryStage);
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton, signupButton, loginStatus);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}