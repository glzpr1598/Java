package chap01.ex02.scope;
// scope는 영역을 의미

public class VarScope {	// 클래스
	
	String str = "아무데서나 쓴다."; // 클래스 안 모든 메서드와 문장안에서도 사용 가능

	public static void main(String[] args) {	// 메서드
		
		int number = 123;	// 메서드와 문장 안에서 사용 가능
		
		for(int i=0; i<5; i++) {	// 특정한 문장
			int sum = 123; 	// 문장 안에서만 쓸 수 있다.
		}

	}

}
