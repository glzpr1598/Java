package chap10.ex11.threadStop;

// 2. InterruptedException 이용(sleep()과 같이 InterruptedException을 던지는 메서드 필요)
public class InterThread1 extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("InterThread1 실행 중");
				Thread.sleep(1); // InterruptedException를 사용하려면 sleep이 있어야 함!
			}
		} catch (InterruptedException e) {
			System.out.println("InterThread1 종료");
		}
	}
	
}
