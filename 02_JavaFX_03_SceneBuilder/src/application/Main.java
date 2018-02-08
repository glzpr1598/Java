package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// 컨트롤 + 레이아웃 -> FXML로
			Parent root = FXMLLoader.load(getClass().getResource("main.fxml")); 
			// 씬
			Scene sc = new Scene(root, 400, 400);
			// 스테이지
			primaryStage.setTitle("Scene Builder로 앱 만들기");
			primaryStage.setResizable(false);
			primaryStage.setScene(sc);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
