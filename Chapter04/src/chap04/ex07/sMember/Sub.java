package chap04.ex07.sMember;

public class Sub {
	// multi 메소드만 static이 아님.

	static int sField = 134;

	static int plus(int a, int b) {
		return a + b;
	}

	static int minus(int a, int b) {
		return a - b;
	}

	int multi(int a, int b) {
		return a * b;
	}

}
