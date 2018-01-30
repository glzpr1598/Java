package chap10.ex09.threadWait;

public class Main {

	public static void main(String[] args) {

		WorkObj obj = new WorkObj();
		
		WorkThread thA = new WorkThread(obj);
		WorkThread thB = new WorkThread(obj);
		
		thA.start();
		thB.start();
		
	}

}
