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

public class MainController implements Initializable {

	@FXML private Button button;
	
	private Stage stage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
//	public void setPrimaryStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//	}

	public void buttonClick() { 
		// Popup 객체 생성
		Popup popup = new Popup();
		// 컨트롤을 통해 스테이지 얻어냄
		stage = (Stage) button.getScene().getWindow();
		try {
			// fxml 불러오기
			Parent root = FXMLLoader.load(getClass().getResource("Custom.fxml"));
			// Popup 객체에 fxml 추가
			popup.getContent().add(root);
			// 보여주기
			popup.setAutoHide(true); // 포커스 이동 시 자동 꺼짐 기능
			popup.show(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
