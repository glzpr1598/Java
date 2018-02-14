package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController {
	
	@FXML private Button btn;
	
	public void move() {
		try {
			// 새로운 레이아웃 가져옴
			Parent rootSub = FXMLLoader.load(getClass().getResource("Sub.fxml"));
			// 기존 레이아웃 가져옴
			AnchorPane rootMain = (AnchorPane) btn.getScene().getRoot();
			// 기존 레이아웃 삭제
			rootMain.getChildren().clear();
			// 새로운 레이아웃 추가
			rootMain.getChildren().add(rootSub);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
