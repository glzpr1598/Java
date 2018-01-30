package chap10.ex06.threadState;

public class WorkThread extends Thread {

	@Override
	public void run() {
		for (long i = 0; i < 100000000; i++) {}
		
		// sleep
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (long i = 0; i < 100000000; i++) {}
	}

}
