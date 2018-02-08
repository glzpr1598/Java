package chap10.ex11.threadStop;

// 쓰레드를 종료시키는 방법
// 1. stop flag 이용
// 2. InterruptedException 이용(sleep()과 같이 InterruptedException을 던지는 메서드 필요)
// 3. interrupted() 이용(주기적으로 인터럽트가 발생했는지 검사)
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		// 1. stop flag 이용
		StopThread st = new StopThread();
		st.start();
		// 1초 후 stop
		Thread.sleep(1000);
		st.stopFlag = true;
		
		Thread.sleep(1000);
		
		// 2. InterruptedException 이용(sleep()과 같이 InterruptedException을 던지는 메서드 필요)
		InterThread1 it1 = new InterThread1();
		it1.start();
		// 1초 후 interrupt
		Thread.sleep(1000);
		it1.interrupt();
		
		Thread.sleep(1000);
		
		// 3. interrupted() 이용(주기적으로 인터럽트가 발생했는지 검사)
		InterThread2 it2 = new InterThread2();
		it2.start();
		// 1초 후 interrupt
		Thread.sleep(1000);
		it2.interrupt();
		
	}

}
