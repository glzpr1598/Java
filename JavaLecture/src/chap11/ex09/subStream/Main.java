package chap11.ex09.subStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 보조스트림 활용하여 txt 파일 복사
public class Main {

	public static void main(String[] args) throws Exception {

		// 파일 경로 설정
		String oriPath = "C:/img/news.txt";
		String tarPath = "C:/img/news_copy.txt";
		
		// 스트림 연결
		FileInputStream fis = new FileInputStream(oriPath);
		FileOutputStream fos = new FileOutputStream(tarPath);
		
		// 보조 스트림 연결
		InputStreamReader reader = new InputStreamReader(fis, "UTF-8"); // 인코딩 지정
		OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
		
		// 데이터 읽기, 쓰기
		char[] data = new char[1024];
		while (reader.read(data) != -1) {
			writer.write(data);
		}
		
		// 스트림 닫기
		fos.flush();
		writer.flush();

		fis.close();
		fos.close();
		writer.close();
		reader.close();	

	}

}
