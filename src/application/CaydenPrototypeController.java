package application;

import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;

public class CaydenPrototypeController {
	
	Stage secondaryStage; 
	@FXML
	private AnchorPane sceneCayden;
	@FXML
	private TextField SourceLog1;
	@FXML
	private TextField SourceLog2;
	@FXML
	private TextField SourceLog3;
	@FXML
	private Text alert;
	//private TextArea SourceText;
	@FXML
	private TextArea TargetLog;
	@FXML
	private Label updateLabel;
	@FXML
	private Button importButton;
	
	inputChecker checkThis = new inputChecker();
	
	
	public void importData(ActionEvent event) {
		int counter = 0;
		//Michael Kofman's additions done while Cayden wasn't available
		//Check to see if Source Log's items are actually correctly inputted.
		if(!checkThis.isValid(SourceLog1.getText()) || !checkThis.isValid(SourceLog2.getText()) || !checkThis.isValid(SourceLog3.getText())) {
			alert.setText("Check inputs");
		}
		else {
			String[] data = {SourceLog1.getText(), SourceLog2.getText(), SourceLog3.getText()};
			
			try {
				//This one's whole job is to write to the Stories.csv. Due to time constraitns,
				//I won't be fully implementing the read functionality into this, I need
				//to make sure it's good with everyone else. However, I'll add my other
				//item into this.
				FileWriter writer = new FileWriter("Stories.csv", true);
				if (counter == 0) { //only did it like this so it would look nicer
		            writer.append(String.join(",", data));
		            writer.append("\n");
		            writer.close();
		            counter++;
				}
				else {
					writer.append("\n");
		            writer.append(String.join(",", data));
		            writer.append("\n");
		            writer.close();
				}
	            
	            //Provide visual feedback
	            String sendToTarget = SourceLog1.getText() + "\n" + SourceLog2.getText() + "\n" + SourceLog3.getText();
	            TargetLog.setText(sendToTarget);
				
			} catch (IOException e) {
				//Just in case anything crashes
				e.printStackTrace();
			}
		}
		
//		String inputText = SourceText.getText();
//		TargetLog.setText(inputText);
		
		
	}
	
}
