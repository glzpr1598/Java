package chap11.ex13.propertiesEx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

// Properties 이용하여 파일 쓰기
// Properties는 한글 지원 X
// 속성을 저장하고 불러올 때 사용함.
// 쓸 때는 메모장을 이용해 바로 쓰고 불러올 때 주로 사용
public class PropOutput {
	
	public static void main(String[] args) throws Exception {
		
		// Properties 객체화
		Properties prop = new Properties();
		
		// Properties에 값 넣기
		prop.put("id", "admin");
		prop.put("pw", "1234");
		prop.put("name", "Kim");
		prop.put("email", "abc@naver.com");
		prop.put("phone", "010-1234-1234");
		
		// 파일 위치 지정
		String path = "src/chap11/ex13/propertiesEx/profile.properties"; // 기본 경로는 프로젝트 폴더
		
		// 스트림 연결
		FileOutputStream fos = new FileOutputStream(path);
		
		// 파일 쓰기
		prop.store(fos, "Kim's profile"); // 사용할 스트림, 주석
		System.out.println("저장 완료.");
		
		// 스트림 닫기
		fos.flush();
		fos.close();
		
	}

}
