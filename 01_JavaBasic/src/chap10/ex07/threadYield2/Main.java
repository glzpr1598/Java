package chap10.ex07.threadYield2;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Thread t2 = new GooGoo(2);
		Thread t3 = new GooGoo(3);
		Thread t4 = new GooGoo(4);
		Thread t5 = new GooGoo(5);
		Thread t6 = new GooGoo(6);
		Thread t7 = new GooGoo(7);
		Thread t8 = new GooGoo(8);
		Thread t9 = new GooGoo(9);

		t2.setPriority(1);
		t3.setPriority(2);
		t4.setPriority(4);
		t5.setPriority(4);
		t6.setPriority(4);
		t7.setPriority(4);
		t8.setPriority(9);
		t9.setPriority(9);
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();

		System.out.println("main() 종료....");
		
	}

}
