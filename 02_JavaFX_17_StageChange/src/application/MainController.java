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
			// 씬을 스테이지에 추가
			Stage stage = new Stage();
			stage.setScene(scene);
			// 스테이지 설정
			stage.setTitle("Second");
			stage.setResizable(false);
			// 스테이지 보여주기
			stage.show();

			// 기존 스테이지 닫기
			Stage primaryStage = (Stage) btnMove.getScene().getWindow();
			// primaryStage.hide(); // 숨기기
			primaryStage.close(); // 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
