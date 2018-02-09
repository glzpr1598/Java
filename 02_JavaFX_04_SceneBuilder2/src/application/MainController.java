package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainController implements Initializable { // Initializable 구현은 생략가능

	@FXML // 생략 가능
	private Label label;
	
	// FXML을 불러올 때 실행하는 메서드
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("FXML 로딩 완료");
	}
	
	public void printMsg() {
		label.setText("버튼을 클릭했습니다.");
	}
	
}
