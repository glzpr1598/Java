package chap13.ex03.lambdaEx;

// 람다식 활용
public class Main {
	
	public static void main(String[] args) {

		// 매개변수 타입 생략 가능(메서드가 하나만 있기 때문)
		OperationA operA = (a, b) -> {
			System.out.println(a + "+" + b + "=" + (a+b));
		};
		operA.plus(3, 4);
		
		// 매개변수가 하나일 경우 괄호 생략 가능
		OperationB operB = a -> {
			System.out.println("한 변의 길이가 " + a + "인 사각형의 넓이 : " + (a*a));
		};
		operB.square(5);
		
		// 매개변수가 없을 경우 괄호만 쓰면 됨
		OperationC operC = () -> {
			System.out.println("매개변수 없음");
		};
		operC.process();
		
		// 한 문장만 있는 경우 코드블록 생략 가능
		OperationD operD = msg -> System.out.println(msg);
		operD.echo1("출력1");
		
		// 반환값이 있는 경우 return 키워드 생략 가능
		OperationE operE = msg -> msg;
		System.out.println(operE.echo2("출력2"));
		
	}
	
	@FunctionalInterface
	interface OperationA{void plus(int a, int b);}
	
	@FunctionalInterface
	interface OperationB{void square(int a);}
	
	@FunctionalInterface
	interface OperationC{void process();}
	
	@FunctionalInterface
	interface OperationD{void echo1(String msg);}
	
	@FunctionalInterface
	interface OperationE{String echo2(String msg);}

}
