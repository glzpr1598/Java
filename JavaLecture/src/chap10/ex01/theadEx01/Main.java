package chap10.ex01.theadEx01;

public class Main {
	// Runnable 객체를 구현하는 방법
	public static void main(String[] args) {

		// work thread 코드를 main thread 코드 밑에 두면 main thread가 모두 끝나고 work thread가 실행됨.
		
		// work thread 생성
		Runnable job = new Job(); // 1. thread가 해야할 일 생성
		Thread thread = new Thread(job); // 2. 그 일을 해야할 thread 생성
		thread.start(); // 3. thread 시작

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
