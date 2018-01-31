package chap10.ex11.threadStop;

// 3. interrupted() 이용(주기적으로 인터럽트가 발생했는지 검사)
public class InterThread2 extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("InterThread2 실행 중");
			if (Thread.interrupted()) // 주기적으로 인터럽트가 발생했는지 검사
				break;
		}
		System.out.println("InterThread2 종료");
	}

}
