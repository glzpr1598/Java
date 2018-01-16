package chap04.ex06.methodOverload;

public class Calculator {
	
	// 두개의 수를 더하는 메서드
	// overload 기능이 없다면 아래 메소드 이름이 모두 달라야 한다. -> 사용자 입장에서 불편함.
	int add(int a, int b) {
		return a + b;
	}
	
	double add(int a, double b) {
		return a + b;
	}
	
	double add(double a, int b) {
		return a + b;
	}
	
	double add(double a, double b) {
		return a + b;
	}

}
