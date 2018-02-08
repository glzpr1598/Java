package chap11.ex02.console;

import java.io.Console;

public class Main {
	
	public static void main(String[] args) {
		
		// readLine() 메서드는 cmd로만 입력 가능.
		// 실행하려면 프로젝트의 bin폴더에서 java chap11.ex02.console.Main 입력
		Console con = System.console();
		
		System.out.println("ID 입력");
		String id = con.readLine();
		System.out.println("PW 입력");
		char[] pw = con.readPassword();
		
		System.out.println(id);
		System.out.println(pw);
		
	}

}
