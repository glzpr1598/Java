package chap11.ex13.propertiesEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

// Properties를 이용해 파일 읽기
// 사용자가 입력한 옵션을 읽어오는데 주로 사용
public class PropInput {

	public static void main(String[] args) throws Exception {
		
		// 파일 경로 설정
		String path = "src/chap11/ex13/propertiesEx/profile.properties";
		
		// 스트림 연결
		FileInputStream fis = new FileInputStream(path);
		
		// 데이터 읽기
		Properties prop = new Properties();
		prop.load(fis);
		
		System.out.println("id : " + prop.get("id"));
		System.out.println("pw : " + prop.get("pw"));
		System.out.println("name : " + prop.get("name"));
		System.out.println("email : " + prop.get("email"));
		System.out.println("phone : " + prop.get("phone"));
		
		// 스트림 닫기
		fis.close();
		
	}

}
