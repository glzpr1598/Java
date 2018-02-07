package chap13.ex01.lambda;

// 람다식 : Java 8 부터 지원
public class Main {

	public static void main(String[] args) {

		// 일반적인 익명 객체
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("익명 객체 실행");
				}
			}
		};
		new Thread(task1).start();

		// 람다식 익명 객체 -> 인터페이스에 추상 메서드가 하나만 있어야함.(함수형 인터페이스)
		Runnable task2 = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("람다 익명 객체 실행");
			}
		};
		new Thread(task2).start();

	}

}
