package chap10.ex02.theadEx02;

public class Job extends Thread {

	@Override
	public void run() { // thread 실행 시 하는 일
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
