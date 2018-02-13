package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {

	@FXML private TreeView<String> treeView;
	
	Image image = new Image(getClass().getResourceAsStream("img/folder.jpg"));
	ImageView[] imageView = new ImageView[7];
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(int i = 0; i < 7; i++) {
			imageView[i] = new ImageView(image);
			// 크기 지정(픽셀)
			imageView[i].setFitHeight(20);
			imageView[i].setFitWidth(18);
		}
		
		/* TreeView 구조
		 * - 영화
		 * 	- 코미디
		 * 		- 한국
		 * 			- 주유소 습격 사건
		 * 			- 라이터를 켜라
		 * 		- 미국
		 * 		- 영국
		 * 	- 로맨스
		 * 	- 액션
		 */
		// 1단계 구조(영화)
		TreeItem<String> movie = new TreeItem<String>("영화", imageView[0]);
		movie.setExpanded(true); // 펼쳐진채로 보여주기
		
		// 2단계 구조(코미디, 로맨스, 액션)
		TreeItem<String> comedy = new TreeItem<String>("코미디", imageView[1]);
		TreeItem<String> romance = new TreeItem<String>("로맨스", imageView[2]);
		TreeItem<String> action = new TreeItem<String>("액션", imageView[3]);
		
		// 1단계(영화) 밑에 2단계(코미디, 로맨스, 액션) 넣기
		movie.getChildren().addAll(comedy, romance, action);
		
		// 3단계 구조
		TreeItem<String> korea = new TreeItem<String>("한국", imageView[4]);
		TreeItem<String> usa = new TreeItem<String>("미국", imageView[5]);
		TreeItem<String> uk = new TreeItem<String>("영국", imageView[6]);
		
		// 2단계 밑에 3단계 넣기
		comedy.getChildren().addAll(korea, usa, uk);
		
		// 4단계 구조
		TreeItem<String> movie1 = new TreeItem<String>("주유소 습격사건");
		TreeItem<String> movie2 = new TreeItem<String>("라이터를 켜라");
		
		// 3단계 밑에 4단계 넣기
		korea.getChildren().addAll(movie1, movie2);
		
		// TreeView에 넣기
		treeView.setRoot(movie);
		
	}
	
	// 더블클릭했을 경우 선택 아이템 출력하도록
	public void selectTree(MouseEvent event) {
		// 더블클릭 체크
		if (event.getClickCount() == 2) {
			TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
			System.out.println(item.getValue());
		}
	}
	
}
