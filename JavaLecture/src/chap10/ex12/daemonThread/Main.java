package chap10.ex12.daemonThread;

// daemon thread : work thread와 달리 main thread가 종료되면 같이 종료됨.
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		DaemonThread dt = new DaemonThread();
		dt.setDaemon(true); // 데몬 쓰레드로 설정
		dt.start();
		Thread.sleep(3000);
		System.out.println("메인 쓰레드 종료");
		// daemon thread가 아니면 "메인 쓰레드 종료" 출력 후에도 "Thread 실행 중"이 계속 출력됨.
	}
	
}
