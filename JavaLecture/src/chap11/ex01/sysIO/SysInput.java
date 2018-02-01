package chap11.ex01.sysIO;

import java.io.IOException;
import java.io.InputStream;

// 데이터 입력
public class SysInput {

	public static void main(String[] args) throws IOException {

		System.out.println("키보드를 입력하세요.");
		InputStream is = System.in; // 시스템에서 입력 받는 Stream
		int ascii;
		
		ascii = is.read(); // 입력받은 내용을 읽는 메서드
		System.out.println(ascii); // int 형태로 출력(아스키 코드)
		System.out.println((char) ascii); // 문자 형태로 출력

	}

}
