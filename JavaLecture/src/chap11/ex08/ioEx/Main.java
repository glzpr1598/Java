package chap11.ex08.ioEx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Scanner로 입력받은 내용을 sample.txt 파일에 저장
// 입력된 내용은 계속 추가되도록(append)
public class Main {

	public static void main(String[] args) throws IOException {
		
		// 파일 경로
		String path = "C:/img/sample.txt";
		
		// File 객체화, 파일 생성
		File file = new File(path);
		if (!file.exists()) { // 파일이 없으면 생성
			file.createNewFile();
		}
		
		// Scanner 정의
		Scanner sc = new Scanner(System.in);
		
		// FileWirter 연결
		FileWriter fw = new FileWriter(file, true); // 이어쓰기 true
		
		// 데이터 읽기, 쓰기
		System.out.print("입력할 내용 : ");
		String data = sc.nextLine();
		fw.write(data);
		
		// 자원 닫기
		sc.close();
		fw.flush();
		fw.close();
		
	}

}
