package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.TableRowModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

	// Label
	@FXML
	private TextField nameField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;

	// TableView, Column
	@FXML
	private TableView<TableRowModel> tableView;
	@FXML
	private TableColumn<TableRowModel, String> nameCol;
	@FXML
	private TableColumn<TableRowModel, String> addressCol;
	@FXML
	private TableColumn<TableRowModel, String> phoneCol;
	@FXML
	private TableColumn<TableRowModel, String> emailCol;

	ObservableList<TableRowModel> list = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = FXCollections.observableArrayList();
		// list.add(new TableRowModel("김길동", "서울", "01012341234", "kim1234@naver.com"));
		tableCall(); // Property 속성 때문에 한번만 실행해도 계속해서 변화 감지
	}

	// 테이블 값 적용
	public void tableCall() {
		// CellData Interface 형태로 모델에 있는 데이터를 반환
		nameCol.setCellValueFactory(cellData -> cellData.getValue().getName());
		addressCol.setCellValueFactory(cellData -> cellData.getValue().getAddress());
		phoneCol.setCellValueFactory(cellData -> cellData.getValue().getPhone());
		emailCol.setCellValueFactory(cellData -> cellData.getValue().getEmail());
		tableView.setItems(list);
	}

	// 등록
	public void regist() {
		list.add(new TableRowModel(nameField.getText(), addressField.getText(), phoneField.getText(), emailField.getText()));
		nameField.clear();
		addressField.clear();
		phoneField.clear();
		emailField.clear();
	}

}
