package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class SubController {

	@FXML	private Button btn;

	public void move() {
		try {
			// 새로운 레이아웃 가져옴
			Parent rootMain = FXMLLoader.load(getClass().getResource("Main.fxml"));
			// 기존 레이아웃 가져옴
			AnchorPane rootSub = (AnchorPane) btn.getScene().getRoot();
			// 기존 레이아웃 삭제
			rootSub.getChildren().clear();
			// 새로운 레이아웃 추가
			rootSub.getChildren().add(rootMain);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
