package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;

public class MainController implements Initializable {

	// FXML의 ID를 변수명으로
	@FXML private Label label1;
	@FXML private RadioButton male;
	@FXML private RadioButton female;
	@FXML private Label result1;
	
	@FXML private Label label2;
	@FXML private CheckBox movie;
	@FXML private CheckBox game;
	@FXML private CheckBox fishing;
	@FXML private Label result2;
	
	@FXML private Label label3;
	@FXML private ToggleButton toggleBtn; 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("FXML 로딩 완료");
	}

	// RadioButton
	public void genderSel() {
		if (male.isSelected()) {
			result1.setText(male.getText());
		} else {
			result1.setText(female.getText());
		}
	}

	// CheckBox
	public void hobbySel() {
		String str = " ";
		if (movie.isSelected()) {
			str += movie.getText() + " ";
		}
		if (game.isSelected()) {
			str += game.getText() + " ";
		}
		if (fishing.isSelected()) {
			str += fishing.getText() + " ";
		}
		result2.setText(str);
	}

	// ToggleButton
	public void toggle() {
		if (toggleBtn.isSelected()) {
			label3.setText("ON");
		} else {
			label3.setText("OFF");
		}
	}
	
}
