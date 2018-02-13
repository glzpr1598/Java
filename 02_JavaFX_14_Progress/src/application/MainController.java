package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;

public class MainController implements Initializable {

	@FXML
	private Label label;
	@FXML
	ProgressBar progressBar;
	@FXML
	ProgressIndicator progressIndicator;
	private int percent = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void plus() {
		if (percent < 100) {
			percent++;
			print(percent);
		}
	}

	public void minus() {
		if (percent > 0) {
			percent--;
			print(percent);
		}
	}

	public void auto() {
		Thread th = new Thread() {
			@Override
			public void run() {
				while (percent < 100) {
					percent++;

					// print(percent); // 이렇게 하면 JavaFX 스레드(UI 스레드)와 충돌이 나서 예외가 발생한다.
					// JavaFX에서 스레드를 사용할 때에는 아래 방법을 사용해야한다.
					Platform.runLater(() -> { // Runnable의 run() 메서드를 람다식으로 표현
						print(percent);
					});
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		th.start();

	}

	public void print(int percent) {
		progressBar.setProgress(percent * 0.01);
		progressIndicator.setProgress(percent * 0.01);
		label.setText(Integer.toString(percent) + "%");
	}

}
