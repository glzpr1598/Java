package chap10.ex05.sync;

public class User2 extends Thread {
	
	private Computer com;
	
	public User2 (Computer com) {
		this.com = com;
		setName("user2 thread");
	}

	@Override
	public void run() {
		com.setScore(100);
	}

}
