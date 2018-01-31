package chap10.ex13.threadGroupEx;

public class WorkThread extends Thread {

	public WorkThread(ThreadGroup threadGroup, String name) {
		super(threadGroup, name);
	}

	@Override
	public void run() {
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		
		System.out.println("현재 쓰레드 그룹 이름 : " + group.getName());
		System.out.println("현재 쓰레드 그룹의 부모그룹 : " + group.getParent());
		group.list(); // 쓰레드 그룹의 정보를 알려준다.(그룹명, 최대 우선순위, 속한 쓰레드 정보)
		
		try {
			while (true) {
				System.out.println(getName() + " 실행 중");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupt로 인한 thread 종료");
		}
	}

}
