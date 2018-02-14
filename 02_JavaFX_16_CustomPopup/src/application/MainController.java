package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {

	// Main.fxml
	@FXML
	private Button btn;
	// Custom.fxml
	@FXML
	private Button btnClose;
	@FXML
	private Label label;

	Stage stage;
	Stage customStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void btnClick() {
		// 메인 스테이지 취득
		stage = (Stage) btn.getScene().getWindow();
		// Stage 설정
		// StageStyle.DECORATED : 일반적인 윈도우 스타일
		customStage = new Stage(StageStyle.DECORATED);
		// customStage 옵션
		customStage.initModality(Modality.WINDOW_MODAL); // 창의 형태
		customStage.initOwner(stage); // 부모창 설정
		customStage.setTitle("팝업창"); // 제목 설정

		try {
			// fxml 불러오기
			Parent root = FXMLLoader.load(getClass().getResource("Custom.fxml"));
			// 씬에 fxml 추가
			Scene scene = new Scene(root);
			// 씬을 스테이지에 추가
			customStage.setScene(scene);
			// 스테이지 보여주기
			customStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 팝업창 닫기
	public void closeClick() {
		// 스테이지를 여기서 안가져오면 Null Pointer Exception
		customStage = (Stage) btnClose.getScene().getWindow(); 
		customStage.close();
	}

}
