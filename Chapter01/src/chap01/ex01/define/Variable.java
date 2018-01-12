package chap01.ex01.define;

public class Variable {

	public static void main(String[] args) {
		
		/* 각 변수를 만들 때 용도를 정한다.*/
		boolean varBool = true;	// 들어갈타입 이름 = 값;
		String varString = "문자열이 들어간다.";
		
		// int : 정수 -> long : 큰 정수
		int varInt = 1;
		long varLong = 10;
		
		// float : 실수 -> double : 큰 실수
		float varFloat = 0.1f;	// float은 숫자 뒤에 f 붙어줘야 함.
		double varDouble = 10.5;		// 소수점 5이상 쓸 것 같으면 double 사용
		
		// syso 입력 후 ctrl + space bar 누르면 자동 완성
		System.out.println(varBool);
		System.out.println(varString);
		System.out.println(varInt);
		System.out.println(varLong);
		System.out.println(varFloat);
		System.out.println(varDouble);

	}

}
