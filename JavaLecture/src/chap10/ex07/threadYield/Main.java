package chap10.ex07.threadYield;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		threadA.yield = true;
		Thread.sleep(1000);
		
		threadA.yield = false;
		threadB.yield = true;
		Thread.sleep(500);
		
		threadA.stop = true;
		threadB.stop = true;
		
	}

}
