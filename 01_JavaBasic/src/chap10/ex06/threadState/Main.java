package chap10.ex06.threadState;

public class Main {

	private static Thread.State state;

	public static void main(String[] args) throws InterruptedException {

		// 워크 스레드 생성 -> 실행 -> sleep -> 실행
		// 메인 스레드에서 감시
		Thread thread = new WorkThread();
		while (true) {
			state = thread.getState();
			System.out.println(state);
			if (state == Thread.State.NEW) {
				thread.start();
			}
			
			// TERMINATED가 되었을 때 감시를 멈춘다.
			if (state == Thread.State.TERMINATED) break;
			
			// 0.5초 간격으로 감시
			Thread.sleep(100);
		}

	}

}
