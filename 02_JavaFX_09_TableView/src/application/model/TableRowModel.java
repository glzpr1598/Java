package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableRowModel {
	
	// 속성 변화를 감지하기 위해 Property 사용
	private StringProperty name;
	private StringProperty address;
	private StringProperty phone;
	private StringProperty email;
	
	public TableRowModel(String name, String address, String phone, String email) {
		this.name = new SimpleStringProperty(name);
		this.address = new SimpleStringProperty(address);
		this.phone = new SimpleStringProperty(phone);
		this.email = new SimpleStringProperty(email);
	}

	// Getters
	public StringProperty getName() {
		return name;
	}
	public StringProperty getAddress() {
		return address;
	}
	public StringProperty getPhone() {
		return phone;
	}
	public StringProperty getEmail() {
		return email;
	}

}
