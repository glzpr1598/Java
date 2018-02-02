package chap11.ex10.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferNotUse {

	public static void main(String[] args) throws Exception {

		// 파일 경로 설정
		String oriPath = "C:/img/image01.gif";
		String tarPath = "C:/img/image01_copy.gif";

		// 스트림 연결
		FileInputStream fis = new FileInputStream(oriPath);
		FileOutputStream fos = new FileOutputStream(tarPath);

		// 시간 체크
		TimeChecker tc = new TimeChecker();
		tc.timeStart(); // 시간 체크 시작
		
		// 데이터 읽고 쓰기
		int data;
		while((data = fis.read()) != -1) {
			fos.write(data);
		}
		
		System.out.println(tc.timeStop()); // 걸린 시간 출력(15949ms)

		// 스트림 닫기
		fos.flush();
		fis.close();
		fos.close();
		
	}

}
