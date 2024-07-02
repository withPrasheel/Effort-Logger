package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MichaelPrototypeController {
	
	//Close button, added so I can understand the relationships between the interactable items,
	//and so that others can follow suit as needed. 
	
	@FXML
	private Button closeButton;
	@FXML
	private AnchorPane sceneMichael;
	
	Stage secondaryStage;

	public void closeMichael(ActionEvent event) {
			secondaryStage  = (Stage) sceneMichael.getScene().getWindow();
			System.out.println("Michael's prototype has been closed.");
			secondaryStage.close();
		
	}
	
	//Text input checker, since we're dealing with data, until we figure out exactly how we want to handle it
	//I'll be using SQL problem inputs from OWASP WSTG-INPV-05 to try to prevent an injection, hypothetically.
	//https://owasp.org/www-project-web-security-testing-guide/latest/4-Web_Application_Security_Testing/07-Input_Validation_Testing/05-Testing_for_SQL_Injection
	@FXML
	private TextField testInput;
	
	//Status label, whole point is to update user of success or not.
	@FXML
	private Label updateLabel;
	
	
	//AncorPane is already made
	
	//I'll leave this here in case we need to have specificity like this in the future.
	/*
	@FXML
	private void initialize() {
		testInput.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				//retrieve the text
				String inputText = testInput.getText();
				System.out.println("The inputted text is: " + inputText);
			}
		});
	} */
	
	//This is to detect a key press, so I can execute it when enter is detected.
	
	public void inputChecker(ActionEvent event) {
		
		//retrieve the text
		String inputText = testInput.getText();
		System.out.println("The inputted text is: " + inputText);
		
		//check to see if the inputs have any SQL issues
		//Test series of inputs:
		/*I don't like pies; and I hate SQL
		This is a -- comment
		SELECT * FROM Users WHERE Username='1' OR '1' = '1' AND Password='1' OR '1' = '1'
		 */
		boolean Valid = isValid(inputText);
		
		if (Valid) { //Check worked, we go ahead.
			System.out.println("Congrats! It's valid, continue");
			updateLabel.setText(inputText);
		} //Check failed, don't let anything through. 
		else{
			updateLabel.setText("Invalid input detected! Try to not have these: .*([';]+|(--)+).*");
			System.out.println("It's not valid, try again.");
		}
		
	}
	
	public boolean isValid(String input) {
		//SQL check, can and will be updated as needed. 
		String sqlIssues = ".*([';]+|(--)+).*";
		
		return !input.matches(sqlIssues);
	}
	
	
}
