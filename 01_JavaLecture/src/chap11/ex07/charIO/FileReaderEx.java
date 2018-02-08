package chap11.ex07.charIO;

import java.io.FileReader;

public class FileReaderEx {

	public static void main(String[] args) throws Exception {
		
		// 파일 경로 설정(한글은 UTF-8로 인코딩 되어있어야 함.)
		String path = "C:/img/news.txt";
		
		// FileReader 연결(FileReader는 character 파일만 연결 할 수 있음.)
		FileReader fr = new FileReader(path);
		
		// 데이터 읽어오기
		int data;
		while((data = fr.read()) != -1) {
			System.out.print((char) data);
		}
		/*
		 * 한글의 경우 처음 부분이 "가가가가가.."로 출력되는 경우가 있다.
		 * 이는 UTF-8로 인코딩 할 때 앞에 BOM 코드가 들어가는데 이와 충돌하여 발생하는 현상이다.
		 * 따라서 Notepad++와 같은 프로그램을 이용하여 UTF-8(BOM 없음)으로 인코딩해야 한다.
		 */
		
		// Reader 닫기
		fr.close();
		
	}

}
