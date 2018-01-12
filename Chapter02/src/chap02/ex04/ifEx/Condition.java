package chap02.ex04.ifEx;

public class Condition {

	public static void main(String[] args) {

		if (true) {
			System.out.println("무조건 실행");
		}

		if (false) { // dead code
			System.out.println("무조건 실행안됨.");
		} else {
			System.out.println("실행이 될까?");
		}

		boolean a = true;
		boolean b = false;

		// a, a==true, a!=false
		if (a != false) {
			System.out.println("a의 값은 true");
		}

		if (!b) {
			System.out.println("b의 값은 false");
		}

		// b==false, b!=true, ||
		if (a == true && b == true) {
			System.out.println("둘 다 만족");
		}

	}

}
