package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// 클래스 생성 방법
// new - other - JavaFX - Classes - JavaFX Main Class
public class Main extends Application {

	// 실제로 화면과 기능에 관여하는 메서드
	@Override
	public void start(Stage primaryStage) {
		// 컨트롤
		Button btn = new Button();
		btn.setText("Click");

		// 컨트롤에 이벤트 부여
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("버튼 클릭");
			}
		});

		// 레이아웃
		StackPane root = new StackPane();
		root.getChildren().add(btn);

		// 씬
		Scene sc = new Scene(root, 400, 400);

		// 스테이지
		primaryStage.setTitle("Button App");
		primaryStage.setScene(sc);
		primaryStage.show();
	}

	// 앱의 실행과 종료에 관여하는 메서드
	public static void main(String[] args) {
		launch(args);
	}
}
