package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class LoginController {

    @FXML
    private TextField usernameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label loginStatus;

    // Reference to the primary stage
    private Stage secondaryStage;

    public void initialize(Stage secondaryStage) {
        this.secondaryStage = secondaryStage;

        // Add event handlers for login and signup
        loginButton.setOnAction(event -> handleLogin());
        signupButton.setOnAction(event -> handleSignup());
    }

    public void handleLogin() {
        String inputUsername = usernameInput.getText();
        String inputPassword = passwordInput.getText();
        boolean authenticated = Authentication.authenticateUser(inputUsername, inputPassword);
        if (authenticated) {
        	loginStatus.setText("Login successful!");
        } else {
        	loginStatus.setText("Login failed. Please try again.");
        }
    }

    public void handleSignup() {
        RegistrationUI.showRegistrationForm(secondaryStage);
    }
}