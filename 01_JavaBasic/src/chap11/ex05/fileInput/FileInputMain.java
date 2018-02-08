package chap11.ex05.fileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// 파일을 InputStream을 통해 콘솔로 출력
public class FileInputMain {

	public static void main(String[] args) throws IOException {

		// 경로 설정
		String path = "C:/img/test.txt";
		
		// File 객체 생성
		File file = new File(path);

		// FileInputStream 연결
		FileInputStream fis = new FileInputStream(file);

		// 내용을 읽어와서 출력
		int data;
		while ((data = fis.read()) != -1) { // read() 메서드는 오류나 파일이 끝에 다다른 경우 -1 반환
			System.out.print((char) data); // 한글은 깨져서 출력됨. -> FileReader 사용해야 함
		}

		// Stream 닫기
		fis.close();
	}

}
