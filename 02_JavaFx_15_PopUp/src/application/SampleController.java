package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class SampleController implements Initializable {

	@FXML private Button button;
	
	private Stage primaryStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void popup() { 
		Popup popup = new Popup();
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("popup.fxml"));
			popup.getContent().add(root);
			popup.show(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
