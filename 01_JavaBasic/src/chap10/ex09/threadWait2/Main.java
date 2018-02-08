package chap10.ex09.threadWait2;

public class Main {

	public static void main(String[] args) {

		WorkThread th = new WorkThread();
		th.start();

		// th에 대하여 동기화 블럭을 설정
		// 만약 main쓰레드가 아래의 블록을 위의 Thread보다 먼저 실행했다면 wait를 하게 되면서 모니터링 락을 놓고 대기
		synchronized (th) {
			try {
				// th.wait()메소드를 호출.
				// 메인쓰레드는 정지
				// th가 5번 값을 더한 후 notify를 호출하게 되면 wait에서 깨어남
				System.out.println("WorkThread가 완료될때까지 기다립니다.");
				th.wait(); // main 쓰레드 정지
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 깨어난 후 결과를 출력
			System.out.println("Total is: " + th.total);
		}
		
	}

}
