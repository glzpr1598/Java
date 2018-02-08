package chap10.ex02.theadEx02;

public class Main {
	// Thread를 상속받는 방법
	public static void main(String[] args) {

		// work thread 생성
		Thread thread = new Job(); // 1. thread를 생성하고 해야할 일을 만들어줌
		thread.start(); // 2. thread 시작

		// main thread가 하는 일
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread : i의 값은 " + i);
			try {
				Thread.sleep(500); // 0.5초 동안 sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
