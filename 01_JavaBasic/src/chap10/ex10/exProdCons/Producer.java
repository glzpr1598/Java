package chap10.ex10.exProdCons;

public class Producer extends Thread {

	private CommonData comData;

	public Producer(CommonData comData) {
		this.comData = comData;
	}

	@Override
	public void run() {
		// 데이터 생산
		for (int i = 0; i < 5; i++) {
			comData.setData("DATA_" + i);
		}
	}
	
}
