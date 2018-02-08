package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

//FXML과 연동되는 클래스
//FXML 파일을 읽어와 객체화하고 각 요소와 메서드를 연결
public class MainController implements Initializable {
	
	@FXML private Label msgLabel; // fxml 파일의 id와 변수명이 일치해야 함
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("FXML이 로드되면 가장먼저 호출되는 메서드");
	}
	
	// OnAction과 연동되는 메서드
	public void printMsg() {
		msgLabel.setText("버튼을 클릭하셨습니다.");
	}
	
}
