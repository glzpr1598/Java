package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ConnectController implements Initializable{
	
	@FXML TextField ipNum;
	@FXML TextField portNum;
	@FXML TextField nickName;
	@FXML Button btn;
	@FXML Label logCheckLabel;
	
	@FXML Label ipLabel;
	@FXML Label portLabel;
	@FXML Label idLabel;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void connectServer() {
		Parent root;
		try {
			ipLabel.setText("");
			portLabel.setText("");
			idLabel.setText("");
			
			Info.ip = ipNum.getText();
			Info.port = Integer.parseInt(portNum.getText());
			Info.nickName = nickName.getText();
			
			if(!Info.ip.equals("127.0.0.1") || Info.port != 5555 || Info.nickName.equals("") || Info.nickName.length() > 3) {
				if(!Info.ip.equals("127.0.0.1")) {
					ipLabel.setText("아이피 다시입력");
				}
				if(Info.port != 5555) {
					portLabel.setText("포트 다시입력");
				}
				if(Info.nickName.equals("")) {
					idLabel.setText("아이디 입력");
				}
				if(Info.nickName.length() > 3) {
					idLabel.setText("3글자 이내로 입력");
				}
			}
			else {
				root = FXMLLoader.load(getClass().getResource("MultiClient.fxml"));
			    Scene scene = new Scene(root, 500, 600);
			    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			    Stage stage = (Stage) btn.getScene().getWindow();
			    stage.setTitle("클라이언트 창");
			    stage.setScene(scene);
			    stage.show();
			    
			    /*	
			    Parent sub = FXMLLoader.load(getClass().getResource("MultiClient.fxml"));
				Scene scene = new Scene(sub, 500, 600);
				AnchorPane mainRoot = (AnchorPane) btn.getScene().getRoot();//메인창에서
				mainRoot.getChildren().add(sub);//추가하여 띄운다.
			     */			
			}


		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void end() {
		Platform.exit();
		System.exit(0);
	}



}
