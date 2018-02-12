package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MainController implements Initializable {

	@FXML
	private Label label;
	@FXML
	private ListView<String> listView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 리스트뷰 세팅
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("JAVA FX8");
		list.add("JAVA FX9");
		list.add("AWT");
		list.add("SWING");
		list.add("GWT");
		list.add("FRONT-END");
		listView.setItems(list);
	}

	// ListView에서 선택한 아이템 가져오기
	public void itemClick() {
		String item = listView.getSelectionModel().getSelectedItem();
		// System.out.println(item);
		label.setText(item);
	}

}
