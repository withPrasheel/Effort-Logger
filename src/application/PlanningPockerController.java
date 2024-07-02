package application;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PlanningPockerController extends Application {
	
	Stage secondaryStage;
	private ObservableList<Story> storyList;
	
	@FXML
	private Button estimateBtn;
	
	@FXML
    private TableColumn<Story, Integer> estTime;

    @FXML
    private TableColumn<Story, String> storyName;

    @FXML
    private TableColumn<Story, Integer> storyPoint;

    @FXML
    private AnchorPane storyTable;
    
    @FXML
    private TableView<Story> table;
    
	public void handleEstimate(ActionEvent event) {
		
		double totalEstTime = 0;

	    for (Story story : storyList) {
	        totalEstTime += story.getEstimationTime();
	    }

	    double averageEstTime = totalEstTime / storyList.size();

	    System.out.println("Average Estimated Time: " + averageEstTime);

	    BorderPane root = new BorderPane();
	    Stage stage = new Stage();

	    Text averageTimeText = new Text("Average Estimated Time: " + averageEstTime);
	    root.setCenter(averageTimeText);

	    Scene scene = new Scene(root, 400, 400);
	    stage.setScene(scene);
	    stage.show();
	}
	
	
	public void initialize() {
		System.out.print("Init working");
		try {
			table = new TableView<>();

	        storyName = new TableColumn<>("Story Name");
	        storyName.setMinWidth(200);
	        storyName.setCellValueFactory(new PropertyValueFactory<>("storyName"));

	        storyPoint = new TableColumn<>("Story Point");
	        storyPoint.setMinWidth(200);
	        storyPoint.setCellValueFactory(new PropertyValueFactory<>("storyPoint"));

	        estTime = new TableColumn<>("Estimation Time");
	        estTime.setMinWidth(200);
	        estTime.setCellValueFactory(new PropertyValueFactory<>("estimationTime"));

	        table.getColumns().addAll(storyName, storyPoint, estTime);
	        
	        storyList = getStories();
	        table.setItems(storyList);

	        storyTable = new AnchorPane();
	        storyTable.getChildren().add(table);
	        
			storyList = FXCollections.observableArrayList();
	        storyList.addAll(getStories()); 
	        storyName.setCellValueFactory(new PropertyValueFactory<>("storyName"));
	        storyPoint.setCellValueFactory(new PropertyValueFactory<>("storyPoint"));
	        estTime.setCellValueFactory(new PropertyValueFactory<>("estimationTime"));

	        table.setItems(storyList);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
    @Override
    public void start(Stage stage) {
        
    }
    
    public void initialize(){
        System.out.println("Test, and WORK GOD DAMN IT");
    }
    
	

    @Override
    public void init() {
    }
    
    public ObservableList<Story> getStories(){
    	ObservableList<Story> stories = FXCollections.observableArrayList();
    	stories.add(new Story("id1","test",3,4,true));
    	stories.add(new Story("id1","test",3,4,false));
    	return stories;
    	
    }

}
