package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.util.List;
import java.util.ArrayList;



public class HughPrototypeController {
	@FXML
	private Button closeButton;		//Button to close window.
	@FXML
	private AnchorPane sceneHugh;		//Anchor pane for prototype scene.
	@FXML
	private TextField estimateInput1;		//Team member 1 input field.
	@FXML
	private TextField estimateInput2;		//Team member 2 input field.
	@FXML
	private TextField estimateInput3;		//Team member 3 input field.
	@FXML
	private TextField estimateInput4;		//Team member 4 input field.
	@FXML
	private Text result;					//Text for displaying result of re-estimation process.
	@FXML
	private ReEstimation reEstimation;		//Instance variable of ReEstimation class for re-estimation logic.
	
	@FXML
	private void beginReEstimation(ActionEvent event) {		//When user clicks the "Begin Re-Estimation" button.
		List<Integer> newEstimates = new ArrayList<>();		//List to hold estimates from GUI inputs.
		try {
			newEstimates.add(Integer.parseInt(estimateInput1.getText()));	//Parse team member 1 input from text fields to estimate list.
			newEstimates.add(Integer.parseInt(estimateInput2.getText()));	//Parse team member 2 input from text fields to estimate list.
			newEstimates.add(Integer.parseInt(estimateInput3.getText()));	//Parse team member 3 input from text fields to estimate list.
			newEstimates.add(Integer.parseInt(estimateInput4.getText()));	//Parse team member 4 input from text fields to estimate list.
			
		if (reEstimation == null) {			//If it is first re-estimation round, create new instance of ReEstimation with logic and threshold/bounds.
			reEstimation = new ReEstimation(newEstimates, 3);		//Estimates must be within 3 to finish process.
		}
		else {
			reEstimation.reEstimationRound(newEstimates);		//Otherwise, update estimation values in list.
		}
		
		double avg = reEstimation.reCalculateAvg();		//Calculate current average estimate.
		result.setText(String.format("Current average: %.2f", avg));	//Display current average estimate.
		
		if (reEstimation.thresholdMet()) {		//If estimation scores are within 3 of each other.
			result.setText(String.format("Final average: %.2f", avg));
		}
		
	} catch (NumberFormatException e) {
		result.setText("Please enter integer estimate only.");		//Handle case where inputs are not in correct type integer.
	}
	}
	
	Stage secondaryStage;
	@FXML
	public void closeHugh(ActionEvent event) {						//To close the stage when re-estimation process is complete.
		secondaryStage  = (Stage) result.getScene().getWindow();
		System.out.println("Hugh's prototype has been closed.");
		secondaryStage.close();
	
	}
}
