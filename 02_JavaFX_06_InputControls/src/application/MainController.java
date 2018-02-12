package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	
	@FXML private TextField title;
	@FXML private PasswordField passwd;
	@FXML private ComboBox<String> publicCombo;
	@FXML private DatePicker endDate;
	@FXML private TextArea content;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("FXML LOAD");
		// 콤보박스 세팅
		ObservableList<String> list
			= FXCollections.observableArrayList("공개", "비공개", "회원공개");
		publicCombo.setItems(list);
	}
	
	// 저장 버튼 클릭
	public void save() {
		System.out.println("저장 완료");
		System.out.println("제목 : " + title.getText());
		System.out.println("비밀번호 : " + passwd.getText());
		System.out.println("공개여부 : " + publicCombo.getValue());
		System.out.println("게시종료일 : " + endDate.getValue());
		System.out.println("내용 : " + content.getText());
	}
	
}
