package chap10.ex04.theadPrio;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// 우선순위는 1~10 까지 줄 수 있다. 높을수록 우선
		// 상수로 값을 대신 할 수 있다.
		// Thread.MAX_PRIORITY -> 10
		// Thread.NORM_PRIORITY -> 5
		// Thread.MIN_PRIORITY -> 1

		for(int i=1; i<=5;i++) {
			Thread th = new WorkThread(i+" 번 스레드");
			th.setPriority(i); //우선순위 부여
			th.start();	
		}			
		//우선 순위로는 제어가 정확히 어렵다. 정확한 제어를 위해서는 동기화를 사용한다.
		
	}

}
