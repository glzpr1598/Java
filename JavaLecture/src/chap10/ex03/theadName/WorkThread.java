package chap10.ex03.theadName;

public class WorkThread extends Thread {

	@Override
	public void run() {
		
		for (int i = 1; i <= 5; i++) {
			System.out.println(getName() + " 쓰레드가 출력");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
