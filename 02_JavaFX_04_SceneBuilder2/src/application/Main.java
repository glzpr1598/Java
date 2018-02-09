package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// 천천히 다시 복습
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// 컨트롤, 레이아웃
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml")); // Parent는 모든 Pane의 상위 클래스
			
			// 씬
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); // 효과
			
			// 스테이지
			primaryStage.setTitle("SceneBuilder 사용하기");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
