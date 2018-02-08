package chap10.ex09.threadWait;

public class WorkObj {
	
	public synchronized void work() {
		System.out.println(Thread.currentThread().getName() + " 실행 중");
		notify(); // 다른 쓰레드 중 하나를 깨움
		try {
			wait(); // 고유 락을 해제하고 쓰레드를 일시정시 시킴
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
