package chap10.ex12.daemonThread;

public class DaemonThread extends Thread {

	@Override
	public void run() {
		
		while (true) {
			try {
				Thread.sleep(500);
				System.out.println("Thread 실행 중");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
