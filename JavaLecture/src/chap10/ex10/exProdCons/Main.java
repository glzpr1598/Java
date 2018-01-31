package chap10.ex10.exProdCons;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonData comData = new CommonData();
		Producer pd = new Producer(comData);
		Consumer cs = new Consumer(comData);
		
		pd.start();
		Thread.sleep(100); // 생산자 쓰레드가 먼저 실행되도록
		cs.start();
		
	}

}
