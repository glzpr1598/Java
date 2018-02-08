package chap04.ex07.sMember;

public class Main {

	public static void main(String[] args) {

		// static 변수와 메소드는 객체화하지 않고 클래스에 직접 접근
		System.out.println(Sub.sField);
		System.out.println(Sub.plus(2, 3));
		System.out.println(Sub.minus(5, 2));
		
		System.out.println();
		
		// static이 아닌 변수와 메소드는 객체화를 해야 접근 가능
		Sub sub = new Sub();
		System.out.println(sub.multi(3, 2));
		// 객체를 통해서도 접근은 가능하지만 정상적인 방법이 아님.(경고 발생)
		System.out.println(sub.plus(5, 2)); // 객체의 원본 클래스(static 영역)에 연결해줌.

	}

}
