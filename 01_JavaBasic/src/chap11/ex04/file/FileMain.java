package chap11.ex04.file;

import java.io.File;
import java.io.IOException;

public class FileMain {
	
	public static void main(String[] args) throws IOException {
		
		// 디렉토리 생성
		File dir = new File("C:/img");
		if (!dir.exists()) { // 해당 디렉토리가 존재하지 않는다면
			System.out.println("존재하지 않는 디렉토리");
			dir.mkdirs(); // 디렉토리 생성
			System.out.println("디렉토리 생성 완료");
		}
		
		// 파일 생성
		File file = new File("C:/img/test.txt");
		if (!file.exists()) { // 해당 파일이 존재하지 않는다면
			System.out.println("존재하지 않는 파일");
			file.createNewFile(); // 파일 생성
			System.out.println("파일 생성 완료");
		}
		
		// 디렉토리 정보 출력
		String[] strArr = dir.list(); // dir 안의 파일이나 디렉토리명을 String으로 반환
		for(String temp : strArr) {
			System.out.println(temp);
		}
		
		System.out.println();
		
		File[] files = dir.listFiles(); // 디렉토리 안의 폴더나 디렉토리를 File으로 반환
		String str;
		for (File temp : files) {
			if (temp.isDirectory()) { // 디렉토리이면
				str = "디렉토리";
			} else {
				str = "파일";
			}
			System.out.println(temp.getName() + "/" + str + "/" + temp.length() + "byte");
		}
		
	}

}
