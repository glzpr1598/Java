package application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController implements Initializable {

	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public void imageSel() {
		// 파일 선택창 띄우기
		FileChooser fc = new FileChooser();
		fc.setTitle("이미지 선택");
		fc.setInitialDirectory(new File("C:/img"));
		// 파일 종류 제한
		ExtensionFilter filter = new ExtensionFilter("image files", "*.jpg", "*.gif", "*.png");
		fc.getExtensionFilters().add(filter);
		// 선택한 파일 반환
		File file = fc.showOpenDialog(null);

		// 이미지뷰에 표시
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			Image image = new Image(bis);
			// Image image = new Image("이미지 주소"); // 이미지 주소로도 불러올 수 있음.
			imageView.setImage(image);
			imageView.setFitHeight(image.getHeight()); // 원본 크기로 가져오기
			imageView.setFitWidth(image.getWidth());
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
