package chap10.ex10.exProdCons;

public class Consumer extends Thread {

	private CommonData comData;

	public Consumer(CommonData comData) {
		this.comData = comData;
	}

	@Override
	public void run() {
		// 데이터 소비
		for (int i = 0; i < 5; i++) {
			comData.getData();
		}
	}

}
