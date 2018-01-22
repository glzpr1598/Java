package chap07.ex01.nestedClass;

public class Main {

	public static void main(String[] args) {

		// 1. 인스턴스 멤버 클래스 사용법
		ExClass ex = new ExClass();
		ExClass.InsClass ins = ex.new InsClass();
		ins.field = 1;
		ins.method();
		// 한 문장으로 객체화
		ins = new ExClass().new InsClass();
		
		System.out.println();
		
		// 2. 정적 멤버 클래스 사용법
		// 일반 member 접근
		ExClass.StaticClass st = new ExClass.StaticClass();
		st.field = 2;
		st.method();
		// static member 접근
		ExClass.StaticClass.stField = 3;
		ExClass.StaticClass.stMethod();
		
		System.out.println();
		
		// 3. 지역 멤버 클래스 사용법
		ExClass ex2 = new ExClass();
		ex2.localMethod();

	}

}
