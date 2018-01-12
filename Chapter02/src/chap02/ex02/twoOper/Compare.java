package chap02.ex02.twoOper;
// 비교 연산자
public class Compare {

	public static void main(String[] args) {
		
		int v1 = 1;
		double v2 = 1.0;
		int v3 = 4;
		String v4 = "JAVA";
		String v5 = new String("JAVA");
		
		System.out.println(v1 == v2);
		System.out.println(v1 != v2);
		System.out.println(v1 < v3);
		System.out.println(v4 == v5);	// false	
		// (중요!!) Java에서는 String 비교를 ==로 하지 않는다.
		System.out.println(v4.equals(v5));		// true
		
		System.out.println();
		
		int val = 6;
		
		System.out.println(val>1 && val<7);
		System.out.println(val%2==0 || val%3==0);
	}

}
