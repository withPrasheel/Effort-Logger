package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
	//Just here to close the program. Used this video as tutorial on this: https://youtu.be/exIQqcQ0lzI - M.K.
	
	@FXML
	private Button closeButton;
	@FXML
	private AnchorPane sceneMain;
	
	Stage primaryStage;
	//Stage secondaryStage;
	
	public void close(ActionEvent event) {
			primaryStage  = (Stage) sceneMain.getScene().getWindow();
			System.out.println("You successfully closed! Goodnight.");
			primaryStage.close();
		
	}
	
	//Everyone's work from here on out
	
	//Namratha's and Prasheel's work here
	public void openNamrathaPrototype(ActionEvent event) {
		try { //just the main that was created by eclipse, updated for opening a second scene. May be changed to switch scene in the future.
			Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("NamrathaPrototype.fxml"));
			Scene scene = new Scene(root);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Cayden's work here
	public void openCaydenPrototype(ActionEvent event) {
		try { //just the main that was created by eclipse, updated for opening a second scene. May be changed to switch scene in the future.
			Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/CaydenPrototype.fxml"));
			Scene scene = new Scene(root);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Michael's work here
	public void openMichaelPrototype(ActionEvent event) {
		try { //just the main that was created by eclipse, updated for opening a second scene. May be changed to switch scene in the future.
			Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/MichaelPrototypeInput.fxml"));
			Scene scene = new Scene(root);
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Hugh's work here
	public void openHughPrototype(ActionEvent event) {
		try {
			Stage secondaryStage = new Stage();		//New instance of stage created.
			Parent root = FXMLLoader.load(getClass().getResource("/HughPrototypeInput.fxml"));		//To load FXML layout from HughPrototypeInput.fxml.
			Scene scene = new Scene(root);			//New instance scene created using root node.
			secondaryStage.setScene(scene);			//Scene is set to secondary stage.
			secondaryStage.show();					//Secondary stage is made visible to user, opening up the prototype test.
		}
		catch (IOException e) {
			//Auto Generated Catch block
			e.printStackTrace();
		}
	}
	
	//Planning Pocker Prototype 
	public void openPlanningPocker(ActionEvent event) {
		try {
			Stage secondaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/PlanningPocker.fxml"));		//To load FXML layout from HughPrototypeInput.fxml.
			Scene scene = new Scene(root);			
			secondaryStage.setScene(scene);			
			secondaryStage.show();
		}
		catch (IOException e) {
			//Auto Generated Catch block
			e.printStackTrace();
		}
	}

	
	
}
