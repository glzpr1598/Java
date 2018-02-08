package chap11.ex10.buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferUse {

	public static void main(String[] args) throws Exception {

		// 파일 경로 설정
		String oriPath = "C:/img/image01.gif";
		String tarPath = "C:/img/image01_copy.gif";

		// 스트림 연결
		FileInputStream fis = new FileInputStream(oriPath);
		FileOutputStream fos = new FileOutputStream(tarPath);
		
		// 보조 스트림 추가(buffer)
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		// 시간 체크
		TimeChecker tc = new TimeChecker();
		tc.timeStart(); // 시간 체크 시작

		// 데이터 읽고 쓰기
		int data;
		while ((data = bis.read()) != -1) {
			bos.write(data);
		}

		System.out.println(tc.timeStop()); // 걸린 시간 출력(187ms)

		// 스트림 닫기
		fos.flush();
		bos.flush();
		fis.close();
		fos.close();
		bis.close();
		bos.close();

	}

}
