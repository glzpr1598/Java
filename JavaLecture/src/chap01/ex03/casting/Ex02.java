package chap01.ex03.casting;

public class Ex02 {

	public static void main(String[] args) {
		/* 명시적 형변환(큰놈 -> 작은놈) 이클립스가 알아서 알려줌(자동완성) */
		int intVal = 44032;
		char charVal;
		charVal = (char) intVal;	// 어떤 형태로 들어갈 것인지 명시해준다.
		System.out.println(charVal);	// '가' 출력
		
		long longVal = 500;
		intVal = (int) longVal;
		
		// double -> float
		double doubleVal = 3.14;
		float floatVal;
		floatVal = (float) doubleVal;
		System.out.println(floatVal);

	}

}
