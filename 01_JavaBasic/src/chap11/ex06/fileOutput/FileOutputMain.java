package chap11.ex06.fileOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// 파일 복사(Input, Output)
public class FileOutputMain {

	public static void main(String[] args) throws Exception {
		
		// 파일 경로
		String oriPath = "C:/img/image.gif"; // 원본 경로
		String tarPath = "C:/img/image_copy.gif"; // 복사본 경로
		
		// Stream 연결
		FileInputStream fis = new FileInputStream(oriPath); // File 객체를 만들지 않고 경로명을 넣어도 됨
		FileOutputStream fos = new FileOutputStream(tarPath, false); // true : 이어쓰기, false : 덮어쓰기
		
		// 데이터 읽고 쓰기(1byte씩)
//		int data;
//		while ((data = fis.read()) != -1) {
//			fos.write(data);
//		}
		
		// 데이터 읽고 쓰기(버퍼 이용)
		int num = 0;
		byte[] buffer = new byte[1024]; // 1KB 단위
		while ((num = fis.read(buffer)) != -1) { // 바이트 수 리턴
			fos.write(buffer, 0, num); // 인자 : 데이터, 시작위치, 바이트 수
		}

		// Stream 닫기
		fis.close();
		fos.flush();
		fos.close();
		
	}
	
}
