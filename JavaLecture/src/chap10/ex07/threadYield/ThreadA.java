package chap10.ex07.threadYield;

public class ThreadA extends Thread {

	boolean stop = false;
	boolean yield = false;
	
	@Override
	public void run() {
		
		while (!stop) {
			if (yield) {
				System.out.println("Thread A yield");
				Thread.yield();
			} else {
				System.out.println("Thread A 실행 중");
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread A 중지");
		
	}

}
