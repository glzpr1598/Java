package chap10.ex05.sync;

public class User1 extends Thread {
	
	private Computer com;
	
	public User1 (Computer com) {
		this.com = com;
		setName("user1 thread");
	}

	@Override
	public void run() {
		com.setScore(500);
	}

}
