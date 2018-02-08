package chap07.ex01.nestedClass;

public class ExClass {
	
	public ExClass() {
		System.out.println("외부 클래스 생성");
	}
	
	// 내부 클래스
	
	// 1. instance member class (인스턴스 멤버 클래스)
	public class InsClass {
		
		public InsClass() {
			System.out.println("인스턴스 멤버 클래스 생성");
		}
		
		int field;
		
		void method() {
			System.out.println("field 출력 : " + field);
		}
		
	}
	
	// 2. static member class (정적 멤버 클래스)
	public static class StaticClass {
		
		public StaticClass() {
			System.out.println("정적 멤버 클래스 생성");
		}
		
		// 일반 member
		int field;
		void method() {
			System.out.println("field 출력 : " + field);
		}
		
		// static member
		static int stField;
		static void stMethod() {
			System.out.println("statc field 출력 : " + stField);
		}
		
	}
	
	// 3. local member class (로컬 멤버 클래스)
	void localMethod() {
		
		class Local {
			
			public Local() {
				System.out.println("Local 클래스 생성");
			}
			
			int field;
			
			void method() {
				System.out.println("field 출력 : " + field);
			}
			
		}
		
		Local local = new Local();
		local.field = 4;
		local.method();
		
	}

}
