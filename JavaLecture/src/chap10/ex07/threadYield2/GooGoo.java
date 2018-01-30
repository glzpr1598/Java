package chap10.ex07.threadYield2;

public class GooGoo extends Thread {
	
	private int dan;

	public GooGoo(int dan) {
		this.dan = dan;
	}

	public void run() {

		if (dan == 8) {
			System.out.println("8단이 yield..");
			// dan 값이 8이면 현재 실행중인 스레드가 block되고 우선권이 동일한
			// 다른 스레드에게 실행할 기회를 줌.
			Thread.yield();
		}

		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " 단 : " + dan + " * " + i + " = " + dan * i);
		}
		
	}
	
}
