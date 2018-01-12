package chap01.ex03.casting;
// 각 자료형의 최대값, 최소값

public class Ex03 {

	public static void main(String[] args) {
		
		// int, long, float, double, char
		// 자료형.MIN_VALUE or MAX_VALUE
		// 위에서 자료형은 클래스 형태!!
		System.out.println("int 최소값 : " + Integer.MIN_VALUE);
		System.out.println("int 최대값 : " + Integer.MAX_VALUE);
		
		System.out.println("long 최소값 : " + Long.MIN_VALUE);
		System.out.println("long 최대값 : " + Long.MAX_VALUE);
		
		System.out.println("float 최소값 : " + Float.MIN_VALUE);
		System.out.println("float 최대값 : " + Float.MAX_VALUE);
		
		System.out.println("double 최소값 : " + Double.MIN_VALUE);
		System.out.println("double 최대값 : " + Double.MAX_VALUE);
		
		System.out.println("char 최소값 : " + Character.MIN_VALUE);
		System.out.println("char 최대값 : " + Character.MAX_VALUE);
		// 위 문장은 정상적으로 출력되지 않음. char는 문자이기 때문에 최대, 최소값이 없음.
		System.out.println(Character.BYTES);	// 2바이트

	}

}
