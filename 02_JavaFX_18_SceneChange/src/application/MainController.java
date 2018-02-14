package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

	@FXML
	private Button btnMove;

	public void move() {
		try {
			// 컨트롤 + 레이아웃
			Parent root = FXMLLoader.load(getClass().getResource("Sub.fxml"));
			// 씬에 추가
			Scene scene = new Scene(root, 200, 200);
			// 기존 스테이지 가져옴
			Stage primaryStage = (Stage) btnMove.getScene().getWindow();
			// 씬을 기존 스테이지에 추가
			primaryStage.setScene(scene);
			// 스테이지 설정
			primaryStage.setTitle("Second");
			// 스테이지 보여주기(안해도 됨)
			// primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
