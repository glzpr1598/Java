package chap10.ex02.theadName;

public class Main {

	public static void main(String[] args) {

		Thread thread = new WorkThread();
		thread.setName("First Thread"); // 지정하지 않으면 default name은 Thread-n
		thread.start();
		
		thread = new WorkThread();
		thread.setName("Second Thread");
		thread.start();
		
		thread = new WorkThread();
		thread.setName("Third Thread");
		thread.start();
		
	}

}
