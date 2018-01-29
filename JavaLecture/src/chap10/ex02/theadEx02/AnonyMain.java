package chap10.ex02.theadEx02;

public class AnonyMain {
	// 익명 객체를 사용하는 방법
	public static void main(String[] args) throws InterruptedException {
		// work thread
		Thread thread = new Thread() { // Thread 익명 객체 생성
			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					System.out.println("work thread : " + i);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start(); // thread 시작

		// main thread
		for (int i = 1; i <= 5; i++) {
			System.out.println("main thread : " + i);
			Thread.sleep(500);
		}

	}

}
