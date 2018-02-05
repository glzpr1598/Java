package chap11.ex07.charIO;

import java.io.FileWriter;

// 파일에 데이터 입력
public class FileWriterEx {

	public static void main(String[] args) throws Exception {
		
		// 파일 경로
		String path = "C:/img/test.txt";
		
		// 스트림 연결
		FileWriter fw = new FileWriter(path, false);
		
		// 데이터 쓰기
		fw.write("Start.\r\n"); // 윈도우즈에서 개행문자는 \r\n
		for (int i = 0; i < 10; i++) {
			fw.write("Input data : " + i + "\r\n");
		}
		fw.write("Finish.\r\n");
		
		// 스트림 닫기
		fw.flush();
		fw.close();

	}

}
