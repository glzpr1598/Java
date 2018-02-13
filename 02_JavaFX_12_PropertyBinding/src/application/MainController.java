package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class MainController implements Initializable {

	@FXML private Label label;
	@FXML private Slider slider;
	@FXML private TextArea textArea1;
	@FXML private TextArea textArea2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/*
		 * 속성 감시1
		 */
		slider.setValue(12);
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				label.setFont(new Font(newValue.doubleValue()));
			}
		});
		
		/*
		 * 속성 감시2 - binding
		 * 단방향 바인딩 : 한쪽 내용만 감시하여 다른쪽을 변화시킴
		 * 	대상2.xxxProperty().bind(대상1.xxxProperty());
		 * 		-> 대상1이 변화하면 대상2가 변화됨
		 * 
		 * 양방향 바인딩 : 양쪽 내용을 감시하여 변화시킴
		 * 	1) 대상2.xxxProperty().bindBidirection(대상1.xxxProperty());
		 * 	2) Bindings.bindBidirection(대상1.xxxProperty(), 대상2.xxxProperty());
		 */
		Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty()); // 한쪽에 텍스트를 입력하면 다른쪽에도 똑같이 입력됨.
		
	}
	
}
