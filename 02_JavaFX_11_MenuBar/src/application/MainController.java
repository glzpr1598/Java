package application;

import javafx.application.Platform;

public class MainController {
	
	public void closeApp() {
		// 앱 종료
		Platform.exit(); // Platform은 앱을 실행시키는 스레드
		// JVM 종료
		System.exit(0);
	}
	
}
