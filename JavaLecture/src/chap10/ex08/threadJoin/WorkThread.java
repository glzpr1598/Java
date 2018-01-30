package chap10.ex08.threadJoin;

public class WorkThread extends Thread {
	
	private int sum;

	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
	}

}
