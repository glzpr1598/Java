package chap11.ex01.sysIO;

import java.io.IOException;
import java.io.OutputStream;

// 데이터 출력
public class SysOut {

	public static void main(String[] args) throws IOException {
		
		OutputStream os = System.out;
		
		// byte 출력
		byte b = 97;
		os.write(b);
		os.flush(); // 데이터를 밖으로 내보냄
		
		// 문자열 출력
		String str = "가나다라";
		byte[] byteArr = str.getBytes(); // String을 byte 배열로 변환(OutputStream은 byte 기반)
		os.write(byteArr);
		os.flush();
		
		os.close();
		
	}
	
}
