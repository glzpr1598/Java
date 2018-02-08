package chap10.ex13.threadGroupEx;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		// 현재 쓰레드의 그룹명
		String groupName = Thread.currentThread().getThreadGroup().getName();
		System.out.println("현재 ThreadGroup 이름 : " + groupName); // default 그룹명은 main
		
		// 쓰레드 그룹 생성
		ThreadGroup threadGroup = new ThreadGroup("myGroup"); // 부모 그룹을 지정하지 않으면 부모는 main
		
		// 쓰레드를 그룹에 등록
		Thread thA = new WorkThread(threadGroup, "myThreadA"); // 생성자 이용
		Thread thB = new WorkThread(threadGroup, "myThreadB"); // 생성자 이용
		
		thA.start();
		thB.start();
		
		Thread.sleep(2000);
		// thA.interrupt();
		// thB.interrupt();
		threadGroup.interrupt(); // 그룹 전체 interrupt
		
	}

}
