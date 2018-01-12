package chap01.ex03.casting;
// casting : 형변환

public class Ex01 {

	public static void main(String[] args) {
		
		/* 묵시적(말없는) 형변환 : 작은 것을 큰 것으로 형변환 */
		int intVal = 10;
		long longVal;
		longVal = intVal;	// 작은 놈이 큰 놈으로(묵시적 형변환)
		
		char charVal = 'A';
		intVal = charVal;
		System.out.println(intVal);	// 아스키코드 65 출력
		
		/* double <- float */
		float floatVal = 1.5f;
		double doubleVal;
		doubleVal = floatVal;	// 묵시적 형변환
		System.out.println(doubleVal);

	}

}
