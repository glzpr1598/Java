package chap10.ex01.theadEx01;

public class Job implements Runnable {

	@Override
	public void run() { // thread 실행 시 하는 일. thread는 예외를 throws 할 수 없다.
		for(int i = 0; i < 10; i++) {
			System.out.println("work thead : i의 값은 " + i);
			try {
				Thread.sleep(500); // 0.5초 동안 sleep
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}

}
