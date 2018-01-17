package chap04.ex08.staticBlock;

public class Main {

	public static void main(String[] args) {

		// 클래스 접근 -> static 블록 실행 -> 원하는 속성 호출
		System.out.println("Monitor의 필드들 호출!");
		System.out.println(Monitor.company); // Monitor 클래스를 호출했기 때문에 static 블록 먼저 실행
		System.out.println(Monitor.model);
		System.out.println(Monitor.price);

	}

}
