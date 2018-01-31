package chap10.ex11.threadStop;

// stop flag 이용
public class StopThread extends Thread {

	boolean stopFlag = false;

	@Override
	public void run() {
		
		while (!stopFlag) {
			System.out.println("StopThread 실행 중");
		}
		System.out.println("StopThread 종료");
		
	}

}
