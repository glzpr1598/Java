package chap10.ex05.sync;

public class Computer {
	
	private int score;

	// 동기화가 안됨
//	public void setScore(int score) {
//		this.score = score;
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() + " : " + this.score);
//	}
	
	// 동기화 메서드 이용 -> 하나의 thread만 접근 가능
//	public synchronized void setScore(int score) {
//		this.score = score;
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() + " : " + this.score);
//	}
	
	// 동기화 블록 -> 특정 영역만 동기화 
	public void setScore(int score) {
		
		synchronized (this) { // 인자는 mutex(사용할 객체)
			this.score = score;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " : " + this.score);
		}
		
	}
	
}
