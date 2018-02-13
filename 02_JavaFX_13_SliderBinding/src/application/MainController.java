package application;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

	@FXML private Slider slider;
	@FXML private TextField textField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.setValue(50);
		textField.setText(Double.toString(slider.getValue()));
		
		Bindings.bindBidirectional(textField.textProperty(), slider.valueProperty(), NumberFormat.getInstance());
	}
	
}
